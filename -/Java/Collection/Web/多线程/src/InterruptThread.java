import org.junit.Test;

public class InterruptThread {
    // 使用共享标记
    @Test
    public void test1() throws InterruptedException {
        MyRunnable_1 target = new MyRunnable_1();
        Thread thread = new Thread(target,"线程一");
        System.out.println(Thread.currentThread().getName()
                +"：让 线程一 开始工作");
        thread.start();
        Thread.sleep(10*1000);
        System.out.println(Thread.currentThread().getName()
                +"：线程一 停止工作");
        target.isQuit = true;
    }
    private static class MyRunnable_1 implements Runnable{
        public volatile boolean isQuit = false;

        @Override
        public void run() {
            while (!isQuit){
                System.out.println(Thread.currentThread().getName()
                        +"：正在运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()
                    +"：停止运行");
        }
    }

    // 通过thread对象调用interrupt()方法通知该线程停止运行
    @Test
    public void test2() throws InterruptedException {
        MyRunnable_2 target = new MyRunnable_2();
        Thread thread = new Thread(target,"线程二");
        System.out.println(Thread.currentThread().getName()
                +"：让 线程二 开始工作");
        thread.start();
        Thread.sleep(10*1000);
        System.out.println(Thread.currentThread().getName()
                +"：线程二 停止工作");
        thread.interrupt();
    }
    private static class MyRunnable_2 implements Runnable{
        @Override
        public void run() {
            // 两种均可
            while (!Thread.interrupted()){
//                while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()
                        +"：正在运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()
                            +"：被中断");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName()
                    +"：停止运行");
        }
    }

    @Test   // 在阻塞
    public void test3(){
        MyRunnable_3 target = new MyRunnable_3();
        Thread thread = new Thread(target,"线程三");
        thread.start();
        thread.interrupt();
    }
    private static class MyRunnable_3 implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("通过异常收到了中断情况");  // 通过异常收到中断通知，并且标志位被清
            }
            for(int i = 0; i < 10; i++)
                System.out.println(Thread.currentThread().isInterrupted());
        }
    }

    @Test   // interrupted()
    public void test4(){
        MyRunnable_4 target = new MyRunnable_4();
        Thread thread = new Thread(target,"线程四");
        thread.start();
        thread.interrupt();
    }
    private static class MyRunnable_4 implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 10; i++)
                System.out.println(Thread.interrupted());   // 只有一开始的true，后边都是false，因为标志位被清
        }
    }

    @Test   // isInterrupted()
    public void test5(){
        MyRunnable_5 target = new MyRunnable_5();
        Thread thread = new Thread(target,"线程五");
        thread.start();
        thread.interrupt();
    }
    private static class MyRunnable_5 implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 10; i++)
                System.out.println(Thread.currentThread().isInterrupted());     //全部是true，因为标志位没有被清
        }
    }


    @Test   // 中断抛出后标志位会重置
    public void test6() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<5; i++)
                        System.out.println(Thread.currentThread().isInterrupted());
                    // 调用 sleep() / wait() / join() 方式时，线程进入阻塞状态，此时也是可以中断
                    // 中断后抛出InterruptedException，标志位会重置 false
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("抛异常");
                }
                for(int i=0; i<5; i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
         Thread.sleep(1000);
        // 与 自定义标志位来中断 相比的优势：可以中断 wait()/join()/sleep() 方法的阻塞线程
        thread.interrupt();
    }

    @Test   // interrupted()、isInterrupted()
    public void test7(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    // interrupted()：并返回之前的标志位，并重置标志位
                    boolean b = Thread.interrupted();
                    // isInterrupted()：获取当前标志位；只获取不重置
//                    boolean b = Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });     // 线程创建之后有一个标志位，默认为 false
        thread.start();
        thread.interrupt();
    }

}

