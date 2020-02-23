import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class WaitTest {
    /**
     * 等待所有线程执行完毕的两种操作：
     * 1.CountDownLatch：初始化一个数值，可以countDown()对进行i--，也可以await()阻塞等待直到i==0
     * 2.Semaphore：release()进行一定数量资源许可的颁发，acquire()阻塞并等待一定数量的许可
     * 相对来说，Semaphore功能更强大，也更灵活一些
     */

    private static int count = 5;
    private static CountDownLatch latch = new CountDownLatch(count);

    private static Semaphore semaphore = new Semaphore(0);

    //main主线程最后执行
    public static void main(String[] args) throws InterruptedException {
        //1.使用CountDownLatch
        /*for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    latch.countDown();//i--；countDown()线程安全
                }
            }).start();
        }
        latch.await();//await()会阻塞并一直等待，直到latch==0
        System.out.println(Thread.currentThread().getName());*/

        //2.使用Semaphore
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    semaphore.release();//颁发一定数量的许可证，无参代表颁发一个数量的许可证
                }
            }).start();
        }
            semaphore.acquire(5);//无参代表请求资源数量为1，也可以请求指定数量的资源
            System.out.println(Thread.currentThread().getName());

    }
}
