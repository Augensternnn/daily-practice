package lesson6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    //    private static final ExecutorService EXE = Executors.newSingleThreadExecutor();
    private static final ExecutorService EXE = Executors.newFixedThreadPool(5);
//    private static final ExecutorService EXE = Executors.newCachedThreadPool();       // 可以缓存的线程池，可以新生成线程池，也可以复用
//    private static final ExecutorService EXE = Executors.newScheduledThreadPool();

    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            final int j = i;
            EXE.submit(new Runnable() {     // 执行任务
                @Override
                public void run() {
                    while(true){        // 当一个任务结束不了时，后面的任务都进入不了，无法执行
                        System.out.println(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        EXE.shutdown();       // 停止
    }
}
