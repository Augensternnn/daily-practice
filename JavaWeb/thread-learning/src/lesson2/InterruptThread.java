package lesson2;

public class InterruptThread {
    /*
    public static void main(String[] args){

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        thread.interrupt();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        });
        thread2.start();
        thread2.interrupt();
    }

     */

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<5; i++){
                        System.out.println(Thread.currentThread().isInterrupted());
                    }
                    // 调用 sleep() / wait() / join() 方式时，线程进入阻塞状态，此时也是可以中断
                    // 中断后抛出InterruptedException，标志位会重置 false
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0; i<5; i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        // Thread.sleep(1000);
        // 与 自定义标志位来中断 相比的优势：可以中断 wait()/join()/sleep() 方法的阻塞线程
        thread.interrupt();


        /*
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    // interrupted()：重置标志位为 false，并返回之前的标志位
                        // boolean tmp = 标志位;   标志位=false   return tmp;
                    boolean b = Thread.interrupted();
                    // isInterrupted()：获取当前标志位；只获取不重置
                    // boolean b = Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });     // 线程创建之后有一个标志位，默认为 false
        thread2.start();
        // thread2.interrupt();     // 修改标志位为 true
        */
    }
}
