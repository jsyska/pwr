package algorithms;

public class Equal extends FrameAllocation {


    public Equal(int[][] processes, int numberOfFrames) {
        super(processes, numberOfFrames);
    }

    public int execute() {
        int numberOfFramesForProcess = framesNumber / processes.length;
        for (LRU processesArr : processes) processesArr.setFramesNumber(numberOfFramesForProcess);
        for (int i = 0; i < processes.length; ++i) {
            processes[i].executeAll();
            faultsCounter += processes[i].getFaultsCounter();
        }
        return faultsCounter;
    }
}