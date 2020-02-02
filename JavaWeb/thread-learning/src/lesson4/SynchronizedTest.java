package lesson4;

public class SynchronizedTest {
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }).start();
    }

//    public static void main(String[] args) {
//        MyObject object = new MyObject();
//        MyObject object2 = new MyObject();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                object.method1();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                object2.method2();
//            }
//        }).start();
//    }

//    public static void main(String[] args) {
//        MyObject object = new MyObject();
//        MyObject object2 = new MyObject();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                object.method1();
//                synchronized (object){
//                    System.out.println(Thread.currentThread().getName());
//                    while(true){
//
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (object){
//                    System.out.println(Thread.currentThread().getName());
//                    while(true){
//
//                    }
//                }
//            }
//        }).start();
//    }
}

class MyObject{
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){

        }
    }
}