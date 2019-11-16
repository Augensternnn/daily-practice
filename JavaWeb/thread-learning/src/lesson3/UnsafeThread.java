package lesson3;

import java.util.ArrayList;
import java.util.List;

public class UnsafeThread {
    // 基本数据类型都有默认的值
    public static int COUNT;    // 默认为0

    public static void main(String[] args) {
        /*
        // 使用方法区中的变量
        // 开启20个线程，每个线程对COUNT进行++操作，进行10000次
        // 预期结果：200000
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        COUNT++;
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(COUNT);
         */


        // 共享堆里的变量
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<20; i++){
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        // COUNT++;
                        list.add(k*10000+j);
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(list.size());

    }
}
