package executorservice;

import java.util.ArrayList;

public class MyTaskQueue {
    private int capacity;
    private ArrayList<MyTask> taskQueue;

    public MyTaskQueue(int capacity) {
        this.taskQueue=new ArrayList<>();
        this.capacity=capacity;
    }

    public synchronized boolean put(MyTask task) {
        if(taskQueue.size() > capacity){
            return false;
        }
        taskQueue.add(task);
        return true;
    }

    public synchronized MyTask get() {
        if(taskQueue.size() == 0){
            return null;
        }
        return taskQueue.remove(0);
    }

    public int size(){
        return taskQueue.size();
    }

    synchronized boolean isFull() {
        return taskQueue.size() == capacity;
    }
}
