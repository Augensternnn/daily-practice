package lesson6;

public class MyThreadPool {

    private MyBlockingQueue<Runnable> queue;

    private MyWorker[] workers;

    public MyThreadPool(int capacity, int size){
        workers = new MyWorker[capacity];
        queue = new MyBlockingQueue<>(size);
        for(int i=0; i<capacity; i++){
            workers[i] = new MyWorker(queue);
            workers[i].start();
        }
    }

    public void execute(Runnable task){
        queue.offer(task);
    }
}

class MyWorker extends Thread{
    private MyBlockingQueue<Runnable> queue;

    public MyWorker(MyBlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            Runnable task = queue.poll();
            task.run();
            // start()：不会等待，直接往下执行；
            // run()：等待执行完毕再往下执行（Runnable没有start方法，只有run方法）
        }
    }
}
