package executorservice;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyThreadPoolConnector {
    private int poolSize;
    private CopyOnWriteArrayList<MyThread> threadsPool;
    private MyTaskQueue taskQueue;
    private boolean isActive;

    public MyThreadPoolConnector(int poolSize, int queueSize) {
        this.poolSize = poolSize;
        this.threadsPool = new CopyOnWriteArrayList<MyThread>();
        this.taskQueue = new MyTaskQueue(queueSize);
        this.isActive=true;
    }

    public boolean execute(MyTask task){
       if(isPoolFull()){
           if(taskQueue.size() > 0){
               return false;
           }
           return putTaskInQueue(task);
       }
       MyThread myThread = new MyThread(task,this);
       addToThreadPool(myThread);
       return true;
    }
    


    /**
     * When you call run() directly, it doesn't start a new thread;
     * instead, it runs the run method in the same thread that called it.
     * We should use start() to create a new thread and run the run method in that new thread.
     */
    private void addToThreadPool(MyThread myThread){
        threadsPool.add(myThread);
        threadsPool.get(threadsPool.size()-1).start();
    }

    private boolean putTaskInQueue(MyTask task){
        boolean status = taskQueue.put(task);
        return status;
    }

    private boolean isPoolFull(){
        if(threadsPool.size() >= poolSize){
            return true;
        }
        return false;
    }

    public void destroy() {
        isActive=false;
       for(int i=0;i<threadsPool.size();i++){
           threadsPool.get(i).interrupt();
       }
    }

    public boolean getIsActive(){
        return isActive;
    }

    public MyTaskQueue getTaskQueue() {
        return taskQueue;
    }
}
