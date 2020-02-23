import org.junit.Test;

import java.util.Scanner;

public class Tests {
    @Test   // insert in Node
    public void insert(){
        Insert first = new Insert();
        Insert second = new Insert();
        Insert third = new Insert();
        first.next=second;
        second=third;
    }
    private static class Insert{
        private Insert next;
    }

    @Test   // extends
    public void extend(){
        // 实际运行时，会根据运行时的对象和传入参数
        // 来决定具体调用哪个方法
        Parent parent = new Child();
    }
    @Test   // 静态代码块、构造方法
    public void test1(){
        System.out.println(new B());
        System.out.println("*********");
        System.out.println(new B());
    }

    @Test   // 打印ABC -- Thread
    public void thread(){
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
        a.start();

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        });
        b.start();

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            }
        });
        c.start();
    }

}

class Parent{
    String value;
    Parent(){
        setValue("ss");
    }
    void setValue(String value){
        System.out.println("parent set value");
    }
}
class Child extends Parent{
    Child(){
        super();
    }
    void setValue(String value){
        System.out.println("Child set value");
    }
}

class A{
    static {
        System.out.println("A静态代码块");
    }
    A(){
        System.out.println("A构造方法");
    }
    {
        System.out.println("A实例代码块");
    }
}
class B extends A{
    static {
        System.out.println("B静态代码块");
    }
    B(){
        System.out.println("B构造方法");
    }
    {
        System.out.println("B实例代码块");
    }
}

