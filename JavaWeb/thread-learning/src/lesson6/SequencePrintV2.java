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
public class SequencePrintV2 {
    private volatile static String[] INFOS = {"A","B","C"};
    private volatile static int INDEX;

    public static void main(String[] args) {
        new Thread(new Task("A")).start();
        new Thread(new Task("B")).start();
        new Thread(new Task("C")).start();
    }
    static class Task implements Runnable{
        private String name;

        public Task(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                for(int i=0; i<10;i++){
                    synchronized (SequencePrintV2.class){
                        while(!name.equals(INFOS[INDEX])){
                            SequencePrintV2.class.wait();
                        }
                        System.out.print(name);
                        if(INDEX==INFOS.length-1){
                            System.out.println();
                        }
                        INDEX = (INDEX+1)%INFOS.length;
                        SequencePrintV2.class.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
