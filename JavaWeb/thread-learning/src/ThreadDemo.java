public class ThreadDemo {
    /*
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
         for(int i = 0; i < 10; i++){
             try {
                 System.out.println(Thread.currentThread().getName() + "：我还活着");
                 Thread.sleep(1 * 1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
            System.out.println(Thread.currentThread().getName() + "：我即将死去");
        });
        System.out.println(Thread.currentThread().getName() + "：ID：" + thread.getId());
        System.out.println(Thread.currentThread().getName() + "：名称：" + thread.getName());
        System.out.println(Thread.currentThread().getName() + "：状态：" + thread.getState());
        System.out.println(Thread.currentThread().getName() + "：优先级：" + thread.getPriority());
        System.out.println(Thread.currentThread().getName() + "：后台线程：" + thread.isDaemon());
        System.out.println(Thread.currentThread().getName() + "：活着：" + thread.isAlive());
        System.out.println(Thread.currentThread().getName() + "：被中断：" + thread.isInterrupted());
        thread.start();
        while (thread.isAlive()){}
        System.out.println(Thread.currentThread().getName() + "：状态：" + thread.getState());
    }

     */

    /*
    private static class MyRunnable implements Runnable{
//        public volatile boolean isQuit = false;
//        @Override
//        public void run() {
//            while (!isQuit){
//                System.out.println(Thread.currentThread().getName() + "：别管我，我忙着转账呢！");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(Thread.currentThread().getName() + "：啊！险些误了大事");
//        }

        @Override
        public void run(){
            while (!Thread.interrupted()){
                System.out.println(Thread.currentThread().getName() + "：别管我，我忙着转账呢！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + "：有内鬼，终止交易！");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "：啊！险些误了大事");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName() + "：让李四开始转账。");
        thread.start();
        Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName() + "：老板来电话了，得赶紧通知李四对方是个骗子！");
//        target.isQuit = true;
        thread.interrupt();
    }

     */

    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("通过异常收到了中断情况");
            }
            for(int i = 0; i < 10; i++)
                System.out.println(Thread.currentThread().isInterrupted());

//            for(int i = 0; i < 10; i++)
//                System.out.println(Thread.interrupted());       // 清楚中断标志

//            for(int i = 0; i < 10; i++)
//                System.out.println(Thread.currentThread().isInterrupted());       // 不清除中断标志
        }
    }

    public static void main(String[] args) {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        thread.start();
        thread.interrupt();
    }

}
