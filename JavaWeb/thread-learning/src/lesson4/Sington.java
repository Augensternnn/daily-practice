package lesson4;

public class Sington {
    // 饿汉式
    private static final Sington SINGTON = new Sington();
    public static Sington getInstance(){
        return SINGTON;
    }

    // 懒汉式
    private static Sington SINGTON2 = null;
    public static Sington getInstance2(){
        // 多个线程可以同时进入这行代码进行判断，都判断为null
        if(SINGTON2 == null){
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }

    // synchronized 第一种写法
    public synchronized static Sington getInstance3(){
        // 多个线程可以同时进入这行代码进行判断，都判断为null
        if(SINGTON2 == null){
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }
    // 等价于
    /*
    public static Sington getInstance3(){
        synchronized (Sington.class){

        }
        // 多个线程可以同时进入这行代码进行判断，都判断为null
        if(SINGTON2 == null){
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }
     */

    // synchronized 第二种写法
    public static Sington getInstance4(){
        // 多个线程可以同时进入这行代码进行判断，都判断为null
        if(SINGTON2 == null){
            synchronized (Sington.class){
                // 可以分解成三步操作：
                // 1.分配对象的内存空间
                // 2.执行对象的初始化
                // 3.把对象赋给引用
                // 可能重排序为132的执行顺序
                if(SINGTON2 == null)
                    SINGTON2 = new Sington();
            }
        }
        return SINGTON2;
    }

    private Sington(){
        // nothing to do
    }

    public static void main(String[] args) {
        FileOperator operator = new FileOperator() {
            @Override
            public void read() {

            }

            @Override
            public synchronized void write() {

            }
        }
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    operator.read();
                }
            }).start();
        }
    }
}
