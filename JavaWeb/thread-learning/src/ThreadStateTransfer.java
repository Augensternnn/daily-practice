public class ThreadStateTransfer {
//    public static void main(String[] args) {
//        Thread t = new Thread(() -> {
//            for(int i = 0; i < 1000_0000; i++){
//            }
//        }, "李四");
//        System.out.println(t.getName() + "：" + t.getState());
//        t.start();
//        while (t.isAlive())
//            System.out.println(t.getName() + "：" + t.getState());
//        System.out.println(t.getName() + "：" + t.getState());
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Object object = new Object();
//        Thread t = new Thread(() -> {
//            synchronized (object) {
//                try {
//                    object.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                for (int i = 0; i < 1000_0000; i++) {
//                }
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        System.out.println(t.getState());
//        t.start();
//        System.out.println(t.getState());
//        Thread.sleep(10);
//        synchronized (object) {
//            for (int i = 0; i < 10; i++)
//                System.out.println(t.getState());
//            object.notify();
//        }
//        while (t.isAlive())
//            System.out.println(t.getState());
//    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName() + "：我跑着呢");
                Thread.yield();
            }
        }, "李四");
        Thread thread2 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName() + "：我跑着呢");
            }
        }, "王五");
        thread1.start();
        thread2.start();
    }

}

