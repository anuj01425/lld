package blockingQ;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQImpl<T> {

    private int capacity;
    private Queue<T> queue;

    public BlockingQImpl(int capacity){
        this.capacity=capacity;
        queue=new LinkedList<>();
    }

    public synchronized void enqueue(T element) throws InterruptedException {
        while (queue.size()==capacity){
            wait();
        }
        if(queue.size()==0){
            notifyAll();
        }
        queue.add(element);
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.size()==0){
            wait();
        }
        if(queue.size()==capacity){
            notifyAll();
        }
        return queue.remove();
    }

}
