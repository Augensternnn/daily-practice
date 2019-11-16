package lesson2;

public class MyThread {
    public static void main(String[] args) throws InterruptedException{
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("啦啦啦啦啦");
            }
        });
        thread.start();
        // 不调用join时，创建线程会耗时较长，下边的main方法的代码会先执行
        // 如果调用join，表示thread（线程的引用）会加入当前线程（JavaMain主线程），等待thread执行完毕再执行后边代码
        thread.join();      // 阻塞方法
        System.out.println("哈哈哈哈哈");
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("啦啦啦啦啦");
            }
        }).start();
        // 下边代码常常先执行，因为以上创建线程部分很耗时
        System.out.println("哈哈哈哈哈");
         */
        /*
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    等价于：
    new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("啦啦啦");
            }
        }).start();
         */
    }
}
