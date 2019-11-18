package lesson4;


public class SafeThread {
    // 基本数据类型都有默认的值
    public static int COUNT;    // 默认为0

    public static void main(String[] args) {
        // 开启20个线程，每个线程对COUNT进行++操作，进行10000次
        // 预期结果：200000
        Object object = new Object();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    Object object = new Object();
                    for (int j = 0; j < 10000; j++) {
//                        COUNT++;
                        // 第一种方法：静态类对象锁定
                        increment();
                        // 第二种方法：对实例对象锁定
//                        synchronized (object){      // 对于启动的20个线程，锁的是同一个
//                            COUNT++;
//                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
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
}
