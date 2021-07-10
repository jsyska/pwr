package algorithms;

public class Proportional extends FrameAllocation {

    public Proportional(int[][] processes, int framesNumber) {
        super(processes, framesNumber);
    }

    @Override
    public int execute() {
        int processesLength = 0;
        for (LRU process : processes)
            processesLength += process.getReferencesArr().length;
        for (LRU process : processes) {
            int framesForProcess = framesNumber * process.getReferencesArr().length / processesLength;
            process.setFramesNumber(framesForProcess);
        }
        for (LRU process : processes) {
            process.executeAll();
            faultsCounter += process.getFaultsCounter();
        }
        return faultsCounter;
    }
}