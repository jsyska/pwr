package algorithms;

public class PageFaultFrequency extends FrameAllocation {


    public PageFaultFrequency(int[][] processes, int framesNumber) {
        super(processes, framesNumber);
    }

    @Override
    public int execute() {
        int numberOfFramesForProcess = framesNumber / processes.length;
        for (LRU process : processes)
            process.setFramesNumber(numberOfFramesForProcess);
        boolean executedAll = false;
        int counter = 0;
        int[] faultsArr = new int[processes.length];
        int[] prioritiesArr = new int[processes.length];
        int available = 0;
        while (!executedAll) {
            counter++;
            executedAll = true;
            for (LRU process : processes) {
                if (!process.executeOne()) executedAll = false;
            }
            if (counter >= numberOfFramesForProcess) {
                for (int i = 0; i < processes.length; ++i) {
                    prioritiesArr[i] = processes[i].getFaultsCounter() - faultsArr[i];
                    faultsArr[i] = processes[i].getFaultsCounter();
                    if (prioritiesArr[i] <= counter / 3 && processes[i].getFramesNumber() > 1) {
                        processes[i].deleteFrame();
                        available++;
                    }
                }
                while (available > 0 && counter > 0) {
                    for (int i = 0; i < processes.length && available > 0; ++i) {
                        if (prioritiesArr[i] >= counter) {
                            processes[i].addFrame();
                            available--;
                        }
                    }
                    counter--;
                }
                counter = 0;
            }

        }
        for (int i = 0; i < processes.length; ++i) {
            faultsCounter += processes[i].getFaultsCounter();
        }
        return faultsCounter;
    }
}