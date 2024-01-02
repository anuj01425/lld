import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQ<Double> queue;

    public Consumer(BlockingQ queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            queue.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
