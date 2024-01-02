package executorservice;
public class MyTask implements Runnable {
    private int id;
    public MyTask(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        success(id);
    }

    private void success(int id){
        System.out.println("Success with id " + id + " thread id "  + Thread.currentThread().getId());
    }
}
