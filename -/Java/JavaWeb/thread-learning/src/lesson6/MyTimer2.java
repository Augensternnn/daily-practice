package lesson6;

    // 不要这个了，重写MyTimer3
import java.util.concurrent.PriorityBlockingQueue;

public class MyTimer2 {
    // 优先级队列：可以取出自己想要的那个优先级高的元素
    // 往优先级队列存储元素要满足：满足比较器 或 可以比较的对象才能往里面传
    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();

    public MyTimer2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    MyTimerTask task = queue.peek();
                    long current = System.currentTimeMillis();
                    if(task.getNext() > current){
                        // 等待
                    }
                }
            }
        }).start();
    }

    public void schedule(Runnable task, long delay, long period){
        queue.offer(new MyTimerTask(delay, period));
    }
}

class MyTimerTask implements Comparable<MyTimerTask>{

    private long next ;
    private long period;

    public MyTimerTask(long next, long period){
        this.next = System.currentTimeMillis() + next;
        this.period = period;
    }
    @Override
    public int compareTo(MyTimerTask o) {
        return Long.compare(next, o.next);
    }

    public long getNext(){
        return next;
    }
}
