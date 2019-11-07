package lesson1;

import java.lang.invoke.MutableCallSite;

public class CreateThread {
    public static void main(String[] args) {
        // 继承 Thread 类
        MyThread t = new MyThread();
        t.start();
        // 实现 Runnable 接口
        MyRunner runner = new MyRunner();
        Thread t2 = new Thread(runner);     //  Runnable tmp = runner;
        t2.start();
        // javaMain 是 java 层面的主线程，和 main 方法中自行创建的线程是同级的
        /*
        while (true){

        }
         */


    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("in thread");
    }
}

class MyRunner implements Runnable{

    @Override
    public void run() {
        System.out.println("in runnable");
        /*
        while (true){

        }

         */
    }
}
