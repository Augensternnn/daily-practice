import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private static class Worker extends Thread{}

    private BlockingQueue<Runnable> jobQueue;
    private int nCurrentThreads;
    private int nThreads;
    private Worker[] workers;

    public ThreadPool(int nThreads,int nCachedJobs){
        this.jobQueue=new ArrayBlockingQueue<>(nCachedJobs);
        this.nCurrentThreads=0;
        this.nThreads=nThreads;
        this.workers=new Worker[nThreads];
    }

    public void execute(Runnable command) throws InterruptedException {
        if(nCurrentThreads<nThreads){
            Worker worker = new Worker();
            workers[nCurrentThreads++]=worker;
            worker.start();
        }else {
            jobQueue.put(command);
        }
    }
}

class ThreadPool2{
    private MyBlockingQueue<Runnable> queue;
    private MyWorker[] workers;

    public ThreadPool2(int capacity,int size){
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
        this.queue=queue;
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

