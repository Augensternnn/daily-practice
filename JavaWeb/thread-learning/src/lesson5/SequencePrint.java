package lesson5;

import lesson1.Sequence;


public class SequencePrint {
    private volatile static String INDEX = "A";

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++){
                        synchronized (SequencePrint.class){
                            while (!INDEX.equals("A"))
                                SequencePrint.class.wait();
                            System.out.println(INDEX);
                            INDEX = "B";
                            SequencePrint.class.notifyAll();
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
