import org.junit.Test;

import java.util.Random;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i = 0; i < 10; i++){
                try {
                    System.out.println(Thread.currentThread().getName()+"：我还在运行");
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"：我即将停止运行");
        });

        System.out.println(Thread.currentThread().getName()+"：ID："+thread.getId());

        System.out.println(Thread.currentThread().getName()+"：名称："+thread.getName());

        System.out.println(Thread.currentThread().getName()+"：状态："+thread.getState());

        System.out.println(Thread.currentThread().getName()+"：优先级："+thread.getPriority());

        System.out.println(Thread.currentThread().getName()+"：后台线程："+thread.isDaemon());

        System.out.println(Thread.currentThread().getName()+"：活着："+thread.isAlive());

        System.out.println(Thread.currentThread().getName()+"：被中断："+thread.isInterrupted());

        thread.start();
        while (thread.isAlive()){}
        System.out.println(Thread.currentThread().getName()+"状态："+thread.getState());
    }

    @Test   // join()
    public void test1() throws InterruptedException {
        Runnable target = ()->{
            for(int i = 0; i < 4; i++){
                try {
                    System.out.println(Thread.currentThread().getName()
                            +"：正在运行");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"：停止工作");
        };

        Thread thread1 = new Thread(target,"线程一");
        Thread thread2 = new Thread(target,"线程二");
        System.out.println("线程一 开始工作");
        thread1.start();
        thread1.join();
        System.out.println("线程一 工作结束，线程二 开始工作");
        thread2.start();
        thread2.join();
        System.out.println("线程二 结束工作");
    }

    @Test   // currentThread()、sleep()
    public void test2() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        System.out.println(System.currentTimeMillis());
        Thread.sleep(3*1000);
        System.out.println(System.currentTimeMillis());
    }

    @Test   // wait()
    public void test3() throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            System.out.println("等待中...");
            object.wait();  // 执行wait()之后就一直等待下去
            System.out.println("等待已过...");
        }
        System.out.println("main方法结束...");
    }

    @Test   // notify()
    public void test4() throws InterruptedException {
        Object object = new Object();
        MyThread2 waitThread = new MyThread2(true,object);
        MyThread2 notifyThread = new MyThread2(false,object);
        Thread thread1 = new Thread(waitThread,"wait线程");
        Thread thread2 = new Thread(notifyThread,"notify线程");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        System.out.println("main方法结束");
    }

    @Test   // notifyAll()
    public void test5() throws InterruptedException {
        Object object = new Object();
        MyThread3 waitThread1 = new MyThread3(true,object);
        MyThread3 waitThread2 = new MyThread3(true,object);
        MyThread3 waitThread3 = new MyThread3(true,object);
        MyThread3 notifyThread = new MyThread3(false,object);
        Thread thread1 = new Thread(waitThread1,"wait线程A");
        Thread thread2 = new Thread(waitThread2,"wait线程B");
        Thread thread3 = new Thread(waitThread3,"wait线程C");
        Thread thread4 = new Thread(notifyThread,"notify线程");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        System.out.println("main方法结束");
    }

}
class  MyThread2 implements Runnable{   // notify()
    private boolean flag;
    private Object obj;

    public MyThread2(boolean flag, Object obj){
        super();
        this.flag=flag;
        this.obj=obj;
    }

    public void waitMethod(){
        synchronized (obj){
            try {
                while (true){
                    System.out.println("wait()方法开始.. "+
                            Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait()方法结束.. "+
                            Thread.currentThread().getName());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void notifyMethod(){
        synchronized (obj){
            try {
                System.out.println("notify()方法开始.. "+
                        Thread.currentThread().getName());
                obj.notify();
                System.out.println("notify()方法结束.. "+
                        Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        if(flag)
            this.waitMethod();
        else
            this.notifyMethod();
    }
}
class  MyThread3 extends MyThread2{   // notifyAll()
    private boolean flag;
    private Object obj;

    public MyThread3(boolean flag, Object obj){
        super(flag,obj);
    }

    public void notifyMethod(){
        synchronized (obj){
            try {
                System.out.println("notify()方法开始.. "+
                        Thread.currentThread().getName());
                obj.notifyAll();
                System.out.println("notify()方法结束.. "+
                        Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
