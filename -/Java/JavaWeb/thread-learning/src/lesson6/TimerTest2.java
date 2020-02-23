package lesson6;

import java.util.concurrent.PriorityBlockingQueue;

public class TimerTest2 {
    public static void main(String[] args) {
        MyTimer3 timer3 = new MyTimer3();
        timer3.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来了");
            }
        }, 3000, 1000);
//        timer3.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我去了");
//            }
//        }, 0, 1000);
    }
}

class MyTimer3{
    private static final PriorityBlockingQueue<Timer3Task> QUEUE = new PriorityBlockingQueue<>();

    public MyTimer3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        // 调用take()阻塞方法，队列为空就等待
                        Timer3Task task = QUEUE.take();
                        long current = System.currentTimeMillis();
                        // 任务时间没有到，就等待。
                        // 因为从队列中已经取出来了，所以要放回去
                        if(task.getNext() > current){
                            // wait or sleep
                            QUEUE.offer(task);
                            synchronized (QUEUE){
                                QUEUE.wait(task.getNext() - current);
                            }
                        }else {
                            // 任务时间到了，可以先执行
                            task.getTask().run();
                            // 间隔时间>0，更新下次执行的任务时间，并放回队列
                            if(task.getPeriod() > 0){
                                task.setNext(task.getNext() + task.getPeriod());
                                QUEUE.offer(task);
                            }else {
                                break;
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     *  提供给其他很多地方使用，为了方便使用，尽可能的把参数简单化
     * @param task        定时任务
     * @param delay       延迟时间
     * @param period      间隔时间
     */
    public void schedule(Runnable task, long delay, long period){
        // 在队列中获取任务时，需要使用传入参数，所以考虑设计自定义的定时任务类
        QUEUE.offer(new Timer3Task(task, delay, period));
        synchronized (QUEUE){
            QUEUE.notify();
        }
    }
}

class Timer3Task implements Comparable<Timer3Task>{

    private Runnable task;
    // 下次任务的执行时间
    private long next;
    // 间隔时间
    private long period;

    public Timer3Task(Runnable task, long delay, long period) {
        this.task = task;
        this.next= System.currentTimeMillis() + delay;
        this.period = period;
    }

    @Override
    public int compareTo(Timer3Task o) {
        return Long.compare(next, o.next);
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

}
