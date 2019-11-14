package lesson1;

public class Sequence {
    // 启动 0-9 编号的10个线程，每个线程打印他的编号
    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            final int j = i;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    // 启动0-9编号的10个线程，每个线程打印他的编号
                    try {
                        Thread.sleep(1000*j);
                        System.out.println(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }

        /*
        for (int i = 0; i < 10; i++) {
            final int j = i;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
         */
    }
}
