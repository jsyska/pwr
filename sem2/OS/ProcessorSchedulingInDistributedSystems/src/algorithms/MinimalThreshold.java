package algorithms;
import java.util.List;
import java.util.Queue;

public class MinimalThreshold extends ProcessorAllocationManager{
    private static final String DESCRIPTION = "Minimal threshold";

    private final int maxMigrationRequests;

    public MinimalThreshold(List<Processor> processors, int maxMigrationRequests) {
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
                    if (nextProcessor.canHandleNextProcessMin()) {
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
