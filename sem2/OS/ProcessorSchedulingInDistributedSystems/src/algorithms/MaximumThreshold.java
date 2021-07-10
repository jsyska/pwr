package algorithms;
import java.util.List;
import java.util.Queue;

public class MaximumThreshold extends ProcessorAllocationManager {
    private static final String DESCRIPTION = "Maximum threshold";

    private final int maxMigrationRequests;

    public MaximumThreshold(List<Processor> processors, int maxMigrationRequests) {
        super(processors);
        this.maxMigrationRequests = maxMigrationRequests;
    }

    @Override
    public ProcessorAllocationStats process(Queue<Process> processes) {
        int migrationRequest = 0;
        int migrations = 0;

        while (!processes.isEmpty()) {
            Process process = processes.poll();
            Processor processor = randomProcessor();
            if (process.isEmpty())
                processAll();

            else {
                boolean processHandled = false;
                for (int i = 0; i < maxMigrationRequests && !processHandled; i++) {
                    ++migrationRequest;
                    Processor nextProcessor = randomProcessor();
                    if (nextProcessor.canHandleNextProcess()) {
                        nextProcessor.addProcess(process);
                        processHandled = true;
                        ++migrations;
                    }
                }
                if (!processHandled)
                    processor.addProcess(process);
            }

            processAll();
        }

        return new ProcessorAllocationStats(DESCRIPTION, averageLoad(), migrationRequest, migrations);
    }
}
