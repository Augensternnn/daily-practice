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

