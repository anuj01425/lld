package executorservice;

public class MyThread extends Thread{
    private MyTask task;
    private MyThreadPoolConnector myThreadPoolConnector;
    public MyThread(MyTask task, MyThreadPoolConnector myThreadPoolConnector){
        this.task = task;
        this.myThreadPoolConnector= myThreadPoolConnector;
    }

    private MyTask getNewTask() {
        return (task != null) ? task : myThreadPoolConnector.getTaskQueue().get();
    }

    private void runTask(MyTask task) {
        task.run();
        this.task = null;
    }


    public void run() {
        while (myThreadPoolConnector.getIsActive()) {
            runTask(getNewTask());
        }
        return;
    }
}
