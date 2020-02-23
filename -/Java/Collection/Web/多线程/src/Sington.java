public class Sington {
    // 饿汉模式1
    private static final Sington SINGTON = new Sington();
    public static Sington getInstance1(){
        return SINGTON;
    }


    // 懒汉模式
    private static Sington instance = null;
    // 单例模式（多线程则不安全）
    public static Sington getInstance2(){
        // 多个线程可以同时进入这行代码进行判断，都判断为null，故线程不安全
        if(instance==null)
            instance = new Sington();
        return instance;
    }
    // 多线程版-性能低
    public synchronized static Sington getInstance3(){
        if(instance==null)
            instance = new Sington();
        return instance;
    }
    // 等同于：
//    public static Sington getInstance3(){
//        synchronized (Sington.class){
//            if(instance == null)
//                instance = new Sington();
//        }
//        return instance;
//    }

    // 多线程版-二次判断-性能高（存在重排序问题）
    public static Sington getInstance4(){
        if(instance==null){
            synchronized (Sington.class){
                // new 一个对象可以分解成三部操作：
                //      1.分配对象的内存空间
                //      2.执行对象初始化
                //      3.把对象赋给引用
                // 可能重排序为132的执行顺序
                if(instance==null)
                    instance=new Sington();
            }
        }
        return instance;
    }

    private volatile static Sington instance2 = null;
    public static Sington getInstance5(){
        if(instance2==null)
            instance2=new Sington();
        return instance2;
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
