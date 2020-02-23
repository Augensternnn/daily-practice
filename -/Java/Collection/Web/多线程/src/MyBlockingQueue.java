import java.util.Random;

// 阻塞式队列：采用循环式队列的方式
public class MyBlockingQueue<E> {
    // 队列元素
    private Object[] elements;
//    private E[] elements;   // 编译时，泛型类型会进行类型擦除，最后都擦除为Object，故数组元素无法初始化
    // 添加元素时的索引
    private int addIndex;
    // 取出元素时的索引
    private int takeIndex;
    // 队列大小：队列实际的大小； 队列元素的大小：数组整体总容量
    private int size;

    public MyBlockingQueue(int capacity){
        elements = new Object[capacity];
    }

    // 返回并取出一个元素
    public synchronized E poll(){
        E element = null;
        try {
            while (size==0)
                wait();
            element=(E)elements[takeIndex];
            takeIndex = (takeIndex + 1) % elements.length;
            size--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return element;
    }

    // 添加元素 -- 多线程版：超过容量则不能添加，一直等待；小于数组容量才可以添加
    public synchronized void offer(E element){
        // 锁类对象可以满足功能，但注意：若在多线程环境下使用这个类会有问题
        // 多线程环境下代表：多个线程new了这个阻塞队列，这时阻塞队列在不同线程里调用offer，会产生同步互斥（因为作用级别在类上）
        // 故应只对当前的对象产生影响
        try {
            while (size==elements.length){
                wait();
            }
            elements[addIndex]=element;
            addIndex = (addIndex+1) % elements.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
    // 非多线程版本
    public void offer(E element){
        elements[addIndex] = element;
        addIndex = (addIndex+1) % elements.length;  // 循环队列，若索引超过数组最大容量，则放入队首
    }
     */

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        int num =new Random().nextInt(100)+1;
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
