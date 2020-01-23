public class UnsafeThread {
    // 不安全
    private static class Counter{
        private long n = 0;

        public void increment(){
            n++;
        }

        public void decrement(){
            n--;
        }

        public long value(){
            return n;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final int COUNT = 1000_0000;
        Counter counter = new Counter();

        Thread thread = new Thread(()->{
            for(int i = 0; i <COUNT; i++)
                counter.increment();
        },"线程一");

        thread.start();
        for (int i = 0; i < COUNT; i++)
            counter.decrement();
        thread.join();
        System.out.println(counter.value());    // 期望最终结果：0
    }

    // 安全
    private static class Counter_1{
        private long n = 0;

        public synchronized void increment(){
            n++;
        }

        public synchronized void decrement(){
            n--;
        }

        public synchronized long value(){
            return n;
        }
    }
}
