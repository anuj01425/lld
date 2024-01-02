package executorservice;

public class Main {
    private static final int CORE_POOL_SIZE = 3;
    private static final int QUEUE_SIZE = 1000;
    private static final int NUMBER_OF_TASKS = 200;


    public static void main(String[] args) throws InterruptedException {
        MyThreadPoolConnector threadPoolExecutor = new MyThreadPoolConnector(
                CORE_POOL_SIZE,
                QUEUE_SIZE
        );

        for (int i = 0; i <= NUMBER_OF_TASKS; ++i) {
            boolean success = false;
            while (!success) {
                if (!threadPoolExecutor.execute(new MyTask(i))) {
                } else {
                    success = true;
                }
            }
        }
        threadPoolExecutor.destroy();
    }
}
