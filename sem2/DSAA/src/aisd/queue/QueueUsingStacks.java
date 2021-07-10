package aisd.queue;

import aisd.stack.ArrayStack;
import aisd.stack.EmptyStackException;
import aisd.stack.FullStackException;

public class QueueUsingStacks<T>{
    ArrayStack<T> stack1;
    ArrayStack<T> stack2;

    public QueueUsingStacks(int queueSize){
        stack1 = new ArrayStack<>(queueSize);
        stack2 = new ArrayStack<>(queueSize);
    }


    public void enQueue(T elem) throws FullStackException {
        stack1.push(elem);
    }

    public T deQueue() throws EmptyQueueException, EmptyStackException, FullStackException {
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new EmptyQueueException();
        else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws FullStackException, EmptyQueueException, EmptyStackException {
        QueueUsingStacks queue = new QueueUsingStacks(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(7);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
