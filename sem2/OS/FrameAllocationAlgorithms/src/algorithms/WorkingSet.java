package algorithms;

import java.util.HashSet;

public class WorkingSet extends FrameAllocation {

    public WorkingSet(int[][] processes, int framesNumber) {
        super(processes, framesNumber);
    }

    @Override
    public int execute() {
        int framesForProcess = framesNumber / processes.length;

        HashSet<Integer>[] referencesArr = new HashSet[processes.length];
        for (int i = 0; i < processes.length; ++i) {
            processes[i].setFramesNumber(framesForProcess);
            referencesArr[i] = new HashSet<>();
        }
        boolean isDone = false;
        int counter = 0;
        int available = 0;
        while (!isDone) {
            counter++;
            isDone = true;
            for (int i = 0; i < processes.length; ++i) {
                if (!processes[i].executeOne()) {
                    referencesArr[i].add(processes[i].getLastRecentlyUsed());
                    isDone = false;
                }
            }
            if (counter >= 2 * framesForProcess) {
                for (int i = 0; i < processes.length; ++i) {
                    if (processes[i].isDone()) {
                        available += processes[i].getFramesNumber();
                        processes[i].setFramesNumber(0);
                    }
                    for (int j = referencesArr[i].size() - processes[i].getFramesNumber(); j > 0 && processes[i].getFramesNumber() > 1; --j) {
                        available++;
                        processes[i].deleteFrame();
                    }
                }
                while (available > 0 && counter > 0) {
                    for (int i = 0; i < processes.length && available > 0; ++i) {
                        int howManyNeeded = referencesArr[i].size() - processes[i].getFramesNumber();
                        if (howManyNeeded > 0) {
                            if (available < howManyNeeded) {
                                available += processes[i].getFramesNumber();
                                processes[i].setFramesNumber(0);
                            } else {
                                processes[i].addFrame();
                                available--;
                            }
                        }
                    }
                    counter--;
                }
                counter = 0;
                for (int i = 0; i < referencesArr.length; ++i)
                    if (processes[i].getFramesNumber() > 0 || processes[i].isDone())
                        referencesArr[i].clear();
            }

        }
        for (int i = 0; i < processes.length; ++i) {
            faultsCounter += processes[i].getFaultsCounter();
        }
        return faultsCounter;
    }
}