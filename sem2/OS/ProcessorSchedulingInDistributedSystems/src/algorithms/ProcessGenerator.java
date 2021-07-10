package algorithms;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessGenerator {
    private final double minLoad;
    private final double maxLoad;
    private final int minTime;
    private final int maxTime;

    private final Random random;

    private double emptyProcessProbability;

    public ProcessGenerator(double minLoad, double maxLoad, int minTime, int maxTime) {
        this.minLoad = minLoad;
        this.maxLoad = maxLoad;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.random = new Random();
        this.emptyProcessProbability = 0.1;
    }

    public Process[] generate(final int N) {
        Process[] processes = new Process[N];
        for (int i = 0; i < N; i++) {
            if (shouldGenerateEmptyProcess())
                processes[i] = Process.EMPTY;
            else
                processes[i] = new Process(randomLoad(), randomTime());
        }
        return processes;
    }

    private int randomTime() {
        return ThreadLocalRandom.current().nextInt(minTime, maxTime + 1);
    }

    private double randomLoad() {
        return ThreadLocalRandom.current().nextDouble(minLoad, maxLoad);
    }

    private boolean shouldGenerateEmptyProcess() {
        final int percent = (int) (emptyProcessProbability * 100);
        return random.nextInt(100) < percent;
    }
}
