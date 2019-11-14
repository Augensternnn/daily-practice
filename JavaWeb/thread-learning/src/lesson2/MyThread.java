package lesson2;

public class MyThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("啦啦啦啦啦");
            }
        });

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
