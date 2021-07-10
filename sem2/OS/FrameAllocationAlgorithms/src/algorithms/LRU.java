package algorithms;

import java.util.LinkedList;

public class LRU {
    private int faultsCounter;
    private int[] referencesCounter;
    private int framesNumber;
    private LinkedList<Integer> frameList;
    private int executionsCounter = 0;

    public LRU(int[] referencesCounter) {
        this.referencesCounter = referencesCounter;
        this.faultsCounter = 0;
        this.framesNumber = 0;
        frameList = new LinkedList<>();
    }

    public int getLastRecentlyUsed() {
        return referencesCounter[executionsCounter - 1];
    }

    public int getFramesNumber() {
        return framesNumber;
    }

    public void setFramesNumber(int framesNumber) {
        this.framesNumber = framesNumber;
    }

    public int getFaultsCounter() {
        return faultsCounter;
    }

    public int[] getReferencesArr() {
        return referencesCounter;
    }

    public boolean isDone() {
        return executionsCounter >= referencesCounter.length;
    }

    public void addFrame() {
        framesNumber++;
    }

    public void deleteFrame() {
        framesNumber--;
    }

    public boolean executeAll() {
        boolean result = false;
        while (executionsCounter < referencesCounter.length) result = executeOne();
        return result;
    }

    public boolean executeOne() {
        while (frameList.size() > framesNumber) frameList.removeFirst();
        if (executionsCounter < referencesCounter.length) {
            if (framesNumber == 0) return false;
            if (!frameList.contains(referencesCounter[executionsCounter])) {
                faultsCounter++;
                if (frameList.size() < framesNumber) frameList.addLast(referencesCounter[executionsCounter]);
                else {
                    frameList.removeFirst();
                    frameList.addLast(referencesCounter[executionsCounter]);
                }
            } else {
                int x = frameList.remove(frameList.indexOf(referencesCounter[executionsCounter]));
                frameList.addLast(x);
            }
            executionsCounter++;
            return false;
        }
        return true;
    }
}