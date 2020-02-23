public class ABC {
    public static void main(String[] args) {

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
                System.out.println("C");
            }
        });
        c.start();
    }
}
