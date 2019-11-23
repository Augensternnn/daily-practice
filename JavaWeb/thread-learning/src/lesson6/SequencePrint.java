package lesson6;

/**
 * 三个线程A、B、C，分别打印字符串A、B、C
 * 要求：循环打印10次
 * 打印结果为：
 * ABC
 * ABC
 * ABC
 * ...
 * 以上总共10次
 */

public class SequencePrint {
    private volatile static String INDEX = "A";

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++){
                        synchronized (SequencePrint.class){
                            while (!INDEX.equals("A")){
                                SequencePrint.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX = "B";
                            SequencePrint.class.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10;i++){
                        synchronized (SequencePrint.class){
                            while(!INDEX.equals("B")){
                                SequencePrint.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX = "C";
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10;i++){
                        synchronized (SequencePrint.class){
                            while(!INDEX.equals("C")){
                                SequencePrint.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX = "A";
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
