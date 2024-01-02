import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQ<java.lang.Double> queue;

    public Producer(BlockingQ queue) {
        this.queue=queue;
    }

    @Override
    public void run(){
        try {
            queue.add(Math.random());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
