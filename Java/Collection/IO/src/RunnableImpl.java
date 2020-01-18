public class RunnableImpl implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在，卖票
                System.out.println(Thread.currentThread().getName()+"----->"+ticket);
                ticket--;
                if(ticket==0)
                    break;
            }
        }
    }

    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        Thread t1 = new Thread(r,"1");
        Thread t2 = new Thread(r,"2");
        Thread t3 = new Thread(r,"3");
        t1.start();
        t2.start();
        t3.start();
    }
}