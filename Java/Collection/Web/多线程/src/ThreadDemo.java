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
    public void test4(){

    }
    class  
}
