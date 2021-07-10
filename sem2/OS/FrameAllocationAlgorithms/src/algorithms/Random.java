package algorithms;

public class Random extends FrameAllocation {


    public Random(int[][] processes, int numberOfFrames) {
        super(processes, numberOfFrames);
    }

    int numberOfFramesForProcess;
    int upperBound = framesNumber;
    public int execute() {
        for (LRU processesArr : processes) {
            numberOfFramesForProcess = getRandomNumberInRange(1,upperBound);
            processesArr.setFramesNumber(numberOfFramesForProcess);
            upperBound -=numberOfFramesForProcess;
        }
        for (int i = 0; i < processes.length; ++i) {
            processes[i].executeAll();
            faultsCounter += processes[i].getFaultsCounter();
        }
        return faultsCounter;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            return 1;
        }

        java.util.Random r = new java.util.Random();
        return r.nextInt((max - min) + 1) + min;
    }
}