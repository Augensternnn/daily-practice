import javafx.concurrent.Worker;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class MultiThread {
    public static void main(String[] args) {
        // 生产者消费者模型
        MessageQueue queue = new MessageQueue();
        Thread producer = new Thread(()->{
            Random random = new Random();
            for(int i = 0; i < 10_0000_0000; i++) {
                try {
                    queue.put(random.nextInt(100000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者");
    }
}

class Singleton{    // 单例模式
    private Singleton(){}

    // 饿汉模式
    private static Singleton instance1 = new Singleton();
    public static Singleton getInstance1(){
        return instance1;
    }

    // 懒汉模式 - 单线程版
    private static Singleton instance2 = null;
    public static Singleton getInstance2(){
        if(instance2==null)
            instance2 = new Singleton();
        return instance2;
    }

    // 懒汉模式 - 多线程版-性能低
    private static Singleton instance3 = null;
    public synchronized static Singleton getInstance3(){
        if(instance3==null)
            instance3 = new Singleton();
        return instance3;
    }

    // 懒汉模式 - 多线程版-二次判断-性能高
    private static Singleton instance4 = null;
    public static Singleton getInstance4(){
        if(instance4==null){
            synchronized (Singleton.class){
                if(instance4==null)
                    instance4=new Singleton();
            }
        }
        return instance3;
    }
}

class MessageQueue{     // 生产者消费者模型
    private int[] items;
    private int putIndex;
    private int takeIndex;
    private volatile int size;

    public MessageQueue(){}

    public MessageQueue(int capacity){
        items = new int[capacity];
        putIndex=0;
        takeIndex=0;
        size=0;
    }

    public void put(int message) throws InterruptedException {
        do{
            synchronized (this){
                if(size<items.length){
                    items[putIndex]=message;
                    putIndex=(putIndex+1)%items.length;
                    size++;
                    notifyAll();
                    return;
                }
            }

            while (size==items.length){
                synchronized (this){
                    if(size==items.length)
                        wait();
                }
            }
        }while (true);
    }

    public int take() throws InterruptedException {
        do{
            synchronized (this){
                if(size>0){
                    int message = items[takeIndex];
                    takeIndex=(takeIndex+1)%items.length;
                    size--;
                    notifyAll();
                    return message;
                }
            }

            while (size==0){
                synchronized (this){
                    if(size==0)
                        wait();
                }
            }
        }while (true);
    }

    public synchronized int size(){
        return size;
    }
}

class Timer{
    private static class TimerTask implements Comparable<TimerTask>{
        private Runnable command;
        private long time;

        private TimerTask(Runnable command,long after){
            this.command=command;
            this.time=System.currentTimeMillis()+after;
        }

        private void run(){
            command.run();
        }

        @Override
        public int compareTo(TimerTask o) {
            return (int)(time-o.time);
        }
    }

    private PriorityBlockingQueue<TimerTask> queue = new PriorityBlockingQueue<>();
    private Object mailbox = new Object();

    private class worker extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    TimerTask task = queue.take();
                    long ms = System.currentTimeMillis();
                    if(task.time>ms){
                        queue.put(task);
                        synchronized (mailbox){
                            mailbox.wait(task.time-ms);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public Timer(){
        Worker woker = new Worker();
        woker.start();
    }

    public void schedule(Runnable command,long after){
        TimerTask task = new TimerTask(command,after);
        queue.offer(task);
        synchronized ()
    }
}

