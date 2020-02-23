package lesson4;

public class Sington {
    // 饿汉式
    private static final Sington SINGTON = new Sington();
    public static Sington getInstance(){
        return SINGTON;
    }



    // 懒汉式
        // 线程不安全
    private static  Sington SINGTON2 = null;
    public static Sington getInstance2(){
        //多个线程可以同时进入这行代码进行判断，都判断为null，故线程不安全
        if(SINGTON2 == null)
            SINGTON2 = new Sington();
        return SINGTON2;
    }
    // synchronized 第一种写法
    public synchronized static Sington getInstance3(){
        if(SINGTON2 == null)
            SINGTON2 = new Sington();
        return SINGTON2;
    }
        // 等同于：
//    public static Sington getInstance3(){
//        synchronized (Sington.class){
//            if(SINGTON2 == null)
//                SINGTON2 = new Sington();
//        }
//        return SINGTON2;
//    }

    // synchronized 第二种写法：存在重排序问题
    public static Sington getInstance4(){
        if (SINGTON2 == null){
            synchronized (Sington.class){
                // new 一个对象可以分解成三部操作：
                //      1.分配对象的内存空间
                //      2.执行对象初始化
                //      3.把对象赋给引用
                // 可能重排序为132的执行顺序
                if(SINGTON2 == null){
                    SINGTON2 = new Sington();
                }
            }
        }
        return SINGTON2;
    }

    // 第三种方法：
    private volatile static  Sington SINGTON3 = null;
    public static Sington getInstance5(){
        if(SINGTON3 == null)
            SINGTON3 = new Sington();
        return SINGTON3;
    }

    private Sington(){
        // nothing to do
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sington.getInstance2();
                }
            }).start();
        }
    }
}
