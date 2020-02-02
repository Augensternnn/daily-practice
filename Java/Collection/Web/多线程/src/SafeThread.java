import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SafeThread {
    // 基本数据类型都有默认的值
    public static int COUNT;    // 默认为0
    @Test   // 使用方法区中的变量
    public void unsafe1(){
        // 开启20个线程，每个线程对COUNT进行++操作，进行10000次
        // 预期结果：200000
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        COUNT++;
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(COUNT);
    }
    @Test   // 共享堆里的变量
    public void unsafe2(){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<20; i++){
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        // COUNT++;
                        list.add(k*10000+j);
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(list.size());
    }
    @Test
    public void safe(){
//        Object object = new Object();
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    Object object = new Object();     // object定义在这里就不安全
                    for(int j=0; j<10000; j++){
                        // 方法一：静态类对象锁定
                        increment();
                        decrement();
                        // 方法二：对实例对象锁定
//                        synchronized (object){      // 对于启动的20个线程，锁的是同一个
//                            COUNT++;
//                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(COUNT);
    }
    // synchronized：同步(互斥)方法
    public synchronized static void increment(){
        COUNT++;
    }
//    public static void increment(){       // 与 public synchronized static void increment(){} 等价
//        synchronized (SafeThread.class) {
//            COUNT++;
//        }
//    }
    public synchronized void increment2(){
    }
//    public void increment2(){         // 与 public synchronized void increment2(){} 等价
//        synchronized (this){
//        }
//    }
    public synchronized static void decrement(){
        COUNT--;
    }





    @Test
    public void test3() throws InterruptedException {
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
    private static class Counter{   // 不安全
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

    private static class Counter_1{     // 安全
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
