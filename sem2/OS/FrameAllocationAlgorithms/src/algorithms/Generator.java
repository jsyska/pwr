package algorithms;
import java.util.Random;

public class Generator {
    private final int numberOfProcesses;
    private final int numberOfPages;
    private final int minNumberOfReferences;
    private final int maxNumberOfReferences;
    private final int localityRange;
    private final Random random;

    public Generator(int numberOfProcesses, int numberOfPages, int minNumberOfReferences, int maxNumberOfReferences, int localityRange) {
        this.numberOfProcesses = numberOfProcesses;
        this.numberOfPages = numberOfPages;
        this.minNumberOfReferences = minNumberOfReferences;
        this.maxNumberOfReferences = maxNumberOfReferences;
        this.localityRange = localityRange;
        random = new Random();
    }

    public int[][] generateProcesses() {
        int[][] processesArr = new int[numberOfProcesses][];
        for (int j = 0; j < processesArr.length; ++j) {
            int referencesCounter = draw(minNumberOfReferences, maxNumberOfReferences);
            int[] referencesArr = new int[referencesCounter];
            referencesArr[0] = draw(0, numberOfPages);
            for (int i = 1; i < referencesCounter; ++i) {
                int min = (referencesArr[i - 1] - localityRange > 0)
                        ? referencesArr[i - 1] - localityRange
                        : 0;
                int max = (referencesArr[i - 1] + localityRange < numberOfPages)
                        ? referencesArr[i - 1] + localityRange
                        : numberOfPages;
                referencesArr[i] = draw(min, max);
            }
            processesArr[j] = referencesArr;
        }
        return processesArr;
    }

    private  int draw(int min, int max) {
        if (max == 0) return 0;
        return random.nextInt(max - min) + min;
    }
}