import org.junit.Test;

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
    @Test
    public void method1(){
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (SequencePrint.class){
                            while (!INDEX.equals("A"))
                                SequencePrint.class.wait();
                            System.out.println(INDEX);
                            INDEX="B";
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

    private volatile static String[] INFOS = {"A","B","C"};
    private volatile static int INDEXS;
    @Test
    public void method2(){
        new Thread(new Task("A")).start();
        new Thread(new Task("B")).start();
        new Thread(new Task("C")).start();
    }
    class Task implements Runnable{
        private String name;

        public Task(String name){
            this.name=name;
        }

        @Override
        public void run() {
            try {
                for(int i=0; i<10; i++){
                    synchronized (SequencePrint.class){
                        while (!name.equals(INFOS[INDEXS])){
                            SequencePrint.class.wait();
                        }
                        System.out.print(name);
                        if(INDEXS==INFOS.length-1){
                            System.out.println();
                        }
                        INDEXS=(INDEXS+1)%INFOS.length;
                        SequencePrint.class.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
