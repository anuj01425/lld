import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQ<T> {

    private BlockingQueue<T> queue;

    public BlockingQ(int capacity) {
        this.queue=new LinkedBlockingDeque<>(capacity);
    }

    public BlockingQ() {
        this.queue=new LinkedBlockingDeque<>();
    }

    public void add(T element) throws InterruptedException {
        System.out.println("Trying to add element to queue: " + element);
        System.out.println("Current size before add: " + this.queue.size());
        this.queue.put(element);
        System.out.println("Added element to queue: " + element);
        System.out.println("Current size after add: " + this.queue.size());
    }

    public T get() throws InterruptedException {
        T value = this.queue.take();
        System.out.println("Current size is "  + this.queue.size()  + " Deque element from queue " + value);
        return value;
    }
}
