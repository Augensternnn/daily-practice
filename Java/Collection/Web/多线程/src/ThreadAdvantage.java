import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 多线程的优势：增加运行速度。在一些场合下可以提高程序的整体运行效率
 *
 * 集合：
 * Collection   |-----List:
 *                          ArrayList：扩容时效率较低，适合查询，不适合中间插入或删除（因为涉及扩容，有数组拷贝）
 *                          LinkedList：查询效率低【可以通过下标去获取，因为实现了 List】
 *                    Set:  HashSet：基于HashMap实现
 *                          TreeSet
 * Map          |-----Map:  HashMap：基于数组+链表+红黑树实现
 *                          TreeMap
 */
public class ThreadAdvantage {
    public static List<String> randomList(){
        // 生成随机字符串：先生成一个char型数组
        char[] chars = {'a','b','c','z','A','Z'};   //  应该包含 a-z 和 A-Z
        List<String> list = new LinkedList<>();
        for(int i = 0; i < 10_0000; i++){
            // new Random().nextInt(100);  // 取一个 0-99 的随机数
            int random = new Random().nextInt(chars.length);
            char c = chars[random];
            list.add(String.valueOf(c));
        }
        return list;
    }

    // 创建10个线程，每个线程获取list中的10000个元素
    public static void main(String[] args) throws InterruptedException {
        List<String> list = randomList();

        // 时间类：1）Date类：java.util.Date、
        //         2）jdk1.8 里的 LocalDateTime
        long start = System.currentTimeMillis();    // 返回当前时间（以毫秒为单位）
        // long start = new Date().getTime();       // 从1970-01-01 00:00 到现在这个时间点执行的毫秒数准换成的long类似数
        Thread[] threads = new Thread[10];
        for(int i=0; i<10; i++){
            final int k = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread current = Thread.currentThread();    // 没有声明对象，定义一个匿名类时的用法
                    System.out.println("id="+current.getId()
                            +",name="+current.getName());
                    // System.out.println(threads[k].getName());   // 有声明时可以这么用（threads[i] = new Thread(new Runnable() {}）
                    for(int j=0; j<10000; j++){
                        // 匿名内部类里面的方法调用，只能调用外部的final变量
                        list.get(k+10000+j);
                    }
                }
            },"线程"+k);
            // System.out.println(threads[i].getName());
            threads[i].start();
        }

        // 因为main线程、子线程是平级关系，同步、并发执行，故取到的执行时间（耗时）不是子线程的，而是main线程的
        // 取子线程执行时间的方法：
            // 方法一：线程让步 -- yield
                // Thread.activeCount()>1：在idea上执行不了，用cmd执行javac可以
                    // 因为 idea 会自动生成一些线程，有一些线程在执行别的事情，故活动的线程(包括idea创建的线程)>1 始终存在
                // Thread.activeCount()>2：将 main线程、idea创建的线程同时运行，这一条件过滤掉
//        while (Thread.activeCount()>2){
//            Thread.yield();
//        }
        // 方法二：调用线程加入/等待操作：join
            // 将线程声明出来，后循环遍历，每个地方加一个join，调用阻塞
        for(Thread thread : threads){
            thread.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start)+"毫秒");
    }
}
