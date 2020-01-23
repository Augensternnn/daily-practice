import org.junit.Test;

public class SynchronizedDemo {
    // 锁的SynchronizedDemo对象
    public synchronized void method1(){
    }
    @Test
    public void test1(){
        SynchronizedDemo demo = new SynchronizedDemo();
        // 进入方法会锁demo指向对象中的锁
        // 出方法会释放demo指向的对象中的锁
        demo.method1();
    }

    // 锁的Synchronized类的对象
    public synchronized  static void method2(){
    }
    @Test
    public void test2(){
        // 进入方法会锁SynchronizedDemo.class指向对象中的锁
        // 出方法会释放SynchronizedDemo.class指向的对象中的锁
        method2();
    }

    // 明确锁的对象
    public void method3(){
        // 进入代码块会锁this指向对象中的锁
        // 出代码块会释放this指向的对象中的锁
        synchronized (this){
        }
    }
    @Test
    public void test3(){
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method3();
    }

    public void method4(){
        // 进入代码块会锁Synchronized.class指向对象中的锁
        // 出代码块会释放Synchronized.class指向的对象中的锁
        synchronized (SynchronizedDemo.class){
        }
    }
    @Test
    public void test4(){
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method4();
    }



}
class MyThread1 implements Runnable{
    private int ticket = 1000;
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            // 在同一时刻，只允许一个线程进入代码块处理
            synchronized (this){    // 表示为程序逻辑上锁
                if(this.ticket>0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName()
                            +"，还有"+this.ticket--+"张票");
                }
            }
        }
    }
    
}
