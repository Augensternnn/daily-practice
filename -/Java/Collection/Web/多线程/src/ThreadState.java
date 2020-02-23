import org.junit.Test;

public class ThreadState {
    public static void main(String[] args) {
        for(Thread.State state : Thread.State.values())
            System.out.println(state);
    }

    @Test   // 关注NEW、RUNNABLE、TERMINATED状态转换
    public void test1(){
        Thread t = new Thread(()->{
            for(int i = 0; i < 1000_0000; i++){
            }
        },"线程一");

        System.out.println(t.getName()+"："+t.getState());
        t.start();
        while (t.isAlive())
            System.out.println(t.getName()+"："+t.getState());
        System.out.println(t.getName()+"："+t.getState());
    }

    @Test   // 关注WAITING、BLOCKED、TIMED_WAITING状态转换
    public void test2() throws InterruptedException {
        Object object = new Object();

        Thread t = new Thread(()->{
            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < 1000_0000; i++){}
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(10);
        synchronized (object){
            for(int i = 0; i < 10; i++)
                System.out.println(t.getState());
            object.notify();
        }
        while (t.isAlive())
            System.out.println(t.getState());
    }

    @Test   // yield()：只是让出CPU，并不会改变自己的状态
    public void test3(){
        Thread thread1 = new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()
                        +"：正在执行");
                Thread.yield();
            }
        },"线程一");

        Thread thread2 = new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()
                        +"：正在执行");
                Thread.yield();
            }
        },"线程二");
        thread1.start();
        thread2.start();
    }
}
