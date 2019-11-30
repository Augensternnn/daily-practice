import java.util.Random;

public class MyBlockingQueue<E> {
    // 队列元素
    private Object[] elements;
    // 添加元素时的位置
    private int addIndex;
    // 取出元素时的位置
    private int takeIndex;
    // 队列大小
    private int size;

    public MyBlockingQueue(int capacity){
        elements = new Object[capacity];
    }

    public synchronized E poll(){
        E element = null;
        try {
            while (size == 0)
                wait();
            element = (E) elements[takeIndex];
            takeIndex = (takeIndex + 1) % elements.length;
            size--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return element;
    }

    public synchronized void offer(E element){
        try {
            while (size == elements.length){
                wait();
            }
            elements[addIndex] = element;
            addIndex = (addIndex+1) % elements.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        int num = new Random().nextInt(100)+1;
                        System.out.println(num);
                        queue.offer(num);
                    }
                }
            }).start();
        }
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        System.out.println(queue.poll());
                    }
                }
            }).start();
        }
    }
}
