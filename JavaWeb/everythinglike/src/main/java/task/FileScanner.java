package task;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FileScanner {
    //1.核心线程数：始终运行的线程数量（正式工）
    //2.最大线程数：有新任务，并且当前运行线程数小于最大线程数，会创建新的线程来处理任务（正式工+临时工）
    //3-4.超过3这个数量.4这个时间单位.2-1（最大线程数-核心线程数）这些线程（临时工）就会关闭
    //5.工作的阻塞队列
    //6.如果超出工作队列的长度，任务要处理的方式
    private ThreadPoolExecutor POOL = new ThreadPoolExecutor(
            3,3,0, TimeUnit.MICROSECONDS,
            new LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void scan(String path) {

    }
}
