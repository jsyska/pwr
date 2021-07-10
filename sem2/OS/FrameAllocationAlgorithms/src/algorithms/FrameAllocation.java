package algorithms;

public abstract class FrameAllocation {
    protected LRU[] processes;
    protected int framesNumber;
    protected int faultsCounter;

    public FrameAllocation(int[][] processes, int framesNumber) {
        this.framesNumber = framesNumber;
        this.processes = new LRU[processes.length];
        for (int i = 0; i < processes.length; ++i) {
            this.processes[i] = new LRU(processes[i]);
        }
    }

    public abstract int execute();

    public int gerProcessResult(int processID) {
        return processes[processID].getFaultsCounter();
    }

}