/**
 * 多线程的优势：增加运行速度。在一些场合下可以提高程序的整体运行效率
 */
public class ThreadAdvantage {
    // 多线程并不一定就能提高速度，如：count不同，实际的运行效果也不同
    private static final long count = 10_0000_0000;

    public static void main(String[] args) throws InterruptedException {
        // 并发方式
        concurrency();
        // 串行方式
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long begin = System.nanoTime();

        // 用一个线程计算 a 的值
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0; i < count; i++)
                    a--;
            }
        });
        thread.start();
        // 主线程内计算 b 的值
        int b = 0;
        for(long i = 0; i < count; i++)
            b--;

        thread.join();  // 等待thread线程运行结束

        // 统计耗时
        long end = System.nanoTime();
        double ms = (end-begin) * 1.0 / 1000 / 1000;
        System.out.printf("并发：%f 毫秒%n",ms);
    }

    private static void serial(){
        // 主线程内计算a、b的值
        long begin = System.nanoTime();
        int a = 0;
        for(long i = 0; i < count; i++)
            a--;
        int b = 0;
        for(long i = 0; i < count; i++)
            b--;
        long end = System.nanoTime();
        double ms = (end-begin) * 1.0 / 1000 / 1000;
        System.out.printf("串行：%f 毫秒%n",ms);
    }
}
