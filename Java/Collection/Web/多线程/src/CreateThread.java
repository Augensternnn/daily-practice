import org.junit.Test;

/**
 * 创建线程方法：继承Thread类、实现Runnable接口
 */
public class CreateThread {
    @Test   // 方法一：继承Thread类
    public void test1(){
        MyThread t = new MyThread();
        t.start();
    }

    @Test   // 方法二：实现Runnable接口
    public void test2(){
        Thread tt = new Thread(new MyRunnable());
        tt.start();
    }

    @Test   // 方法三：使用匿名类创建Thread子类对象
    public void test3(){
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("使用匿名类创建Thread子类对象1");
            }
        };
        t1.start();
    }

    @Test   // 方法四：使用匿名类创建Runnable子类对象
    public void test4(){
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名类创建Runnable子类对象");
            }
        });
        t2.start();
    }

    @Test   // 方法五：使用lambda表达式创建Runnable子类对象
    public void test5(){
        Thread t3 = new Thread(()-> System.out.println("使用匿名类创建Thread子类对象2"));
        Thread t4 = new Thread(()->{
            System.out.println("使用匿名类创建Thread子类对象3");
        });
        t3.start();
        t4.start();
    }

    @Test   // 构造方法
    public void test6(){
        Thread t1 = new Thread();
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread("这是我的名字1");
        Thread t4 = new Thread(new MyRunnable(), "这是我的名字2");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程运行的代码1");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程运行的代码2");
    }
}
