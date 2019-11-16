package lesson2;

public class StopThread {
    /**
     * 是否被中断：默认没有被中断 false
     */
    // 用一个标志位来停止、中断线程，但有一些限制条件
    private static volatile boolean myInterrupted;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!myInterrupted){
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(5000);
        myInterrupted = true;
    }
}
