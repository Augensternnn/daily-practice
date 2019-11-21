public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
          @Override
            public void run(){
              System.out.println("使用匿名类创建 Thread 子类对象");
          }
        };
        t1.start();
    }
}
