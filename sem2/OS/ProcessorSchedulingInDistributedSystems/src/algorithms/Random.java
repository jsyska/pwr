package algorithms;
import java.util.List;
import java.util.Queue;

public class Random extends ProcessorAllocationManager {
    private static final String DESCRIPTION = "Random";

    public Random(List<Processor> processors) {
        super(processors);
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
                    migrationRequest += 1;
                   Processor nextProcessor = randomProcessor();
                    nextProcessor.addProcess(process);
                    processor.addProcess(process);
                    if(nextProcessor.canHandleNextProcessRandom()){
                        migrations+=1;
                        nextProcessor.addProcess(process);
                        processor.addProcess(process);
                    }
            }

            processAll();
        }

        return new ProcessorAllocationStats(DESCRIPTION, averageLoad(), migrationRequest, migrations);
    }

}
