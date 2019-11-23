public class ThreadDemo2 {
    // 线程不安全
    /*
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
        Thread thread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++)
                counter.increment();
        }, "李四");
        thread.start();
        for (int i = 0; i < COUNT; i++)
            counter.decrement();
        thread.join();
        System.out.println(counter.value());
    }

     */

    // 线程安全
    /*
    private static class Counter{
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
    public static void main(String[] args) throws InterruptedException {
        final int COUNT = 1000_0000;
        Counter counter = new Counter();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++)
                counter.increment();
        }, "李四");
        thread.start();
        for (int i = 0; i < COUNT; i++)
            counter.decrement();
        thread.join();
        System.out.println(counter.value());
    }

     */

    /*
    private static class Counter{
        private int n1 = 0;
        private int n2 = 0;
        private int n3 = 0;
        private int n4 = 0;
        private int n5 = 0;

        public void write(){
            n1 = 1;
            n2 = 2;
            n3 = 3;
            n4 = 4;
            n5 = 5;
        }

        public void read(){
            System.out.println("n1 = " + n1);
            System.out.println("n2 = " + n2);
            System.out.println("n3 = " + n3);
            System.out.println("n4 = " + n4);
            System.out.println("n5 = " + n5);
        }
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            counter.read();
        }, "读");
        Thread thread2 = new Thread(() -> {
            counter.write();
        }, "写");
        thread1.start();
        thread1.start();
    }

     */

    static class MyThread implements Runnable{
        private int ticket = 1000;  // 一共十张票
        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                synchronized (this){
                    if(this.ticket > 0){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                        }
                        System.out.println(Thread.currentThread().getName() + "，还有" + this.ticket -- + " 张票");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "黄牛A");
        Thread t2 = new Thread(mt, "黄牛B");
        Thread t3 = new Thread(mt, "黄牛C");
        t1.start();
        t2.start();
        t3.start();
    }

}
