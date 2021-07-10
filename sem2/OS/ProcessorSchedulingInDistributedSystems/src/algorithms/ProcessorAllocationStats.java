package algorithms;
import static java.lang.String.format;

public class ProcessorAllocationStats {
    private final String description;
    private final double averageLoad;
    private final int loadRequests;
    private final int loadMigrations;

    public ProcessorAllocationStats(String description, double averageLoad, int loadRequests, int loadMigrations) {
        this.description = description;
        this.averageLoad = averageLoad;
        this.loadRequests = loadRequests;
        this.loadMigrations = loadMigrations;
    }

    @Override
    public String toString() {
        return format("%s:\n1) Average Cpu Load: %.2f\n"
                        + "2) Number of requests: %d\n3) Number of migrations: %d\n",
                description, averageLoad, loadRequests, loadMigrations);
    }

    public double getAverageLoad() {
        return round(averageLoad,2);
    }

    public int getLoadRequests() {
        return loadRequests;
    }

    public int getLoadMigrations() {
        return loadMigrations;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}
