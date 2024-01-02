public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        BlockingQ<Double> queue = new BlockingQ<>(2);

        /**
         * Here's the typical flow:
         *
         * The main thread enters the loop and creates a new Producer object and a new Thread object (t) for each iteration.
         * The start() method is called on each thread (t). This initiates the execution of the run method in the Producer class on a new thread.
         * The main thread continues its loop without waiting for the threads (t) to complete. It may proceed with the next iteration or with any other code following the loop.
         * The newly created threads (t) will run concurrently, executing the run method of the Producer class. The run method adds an element to the queue and then completes.
         * If the main thread has more code following the loop, it will continue to execute that code.
         */
        for(int i=0;i<10;i++){
           Producer producer = new Producer(queue);
           Thread t = new Thread(producer);
           t.start();
        }


        for(int i=0;i<2;i++){
            Consumer consumer = new Consumer(queue);
            Thread t = new Thread(consumer);
            t.start();
        }
    }
}