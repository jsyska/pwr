package aisd.queue;

public class Josephus {

    public static void main(String[] args) throws FullQueueException, EmptyQueueException {
        int n = 8;
        int k = 3;
        ArrayQueue queue = new ArrayQueue();
        for(int i = 1;i<n+1; i++){
            queue.enqueue(i);
        }

        while (!queue.isEmpty()){
            for(int i =0 ; i<k-1;i++){
                queue.enqueue(queue.dequeue());
            }
            System.out.println(queue.dequeue()+" ");
        }
        System.out.println();
    }

}
