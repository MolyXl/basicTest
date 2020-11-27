package thread.implement;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class TheradPoolTest {
    public static void main(String[] args) {
        ExtendThread extendThread = new ExtendThread();
        //查看源码
        //可缓存线程池：
        //线程数无限制
        //有空闲线程则复用空闲线程，若无空闲线程则新建线程
        //一定程序减少频繁创建/销毁线程，减少系统开销
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //cachedThreadPool.submit(extendThread);
        //核心线程0,最大线程数不限,非核心线程存活时间,时间单位,阻塞队列{
        //这个队列接收到任务的时候，会直接提交给线程处理，而不保留它
        // 如果所有线程都在工作怎么办？那就新建一个线程来处理这个任务！
        // 所以为了保证不出现<线程数达到了maximumPoolSize而不能新建线程>的错误，使用这个类型队列的时候，maximumPoolSize一般指定成Integer.MAX_VALUE，即无限大
        // }
        new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        //单线程化的线程池：
        //有且仅有一个工作线程执行任务
        //所有任务按照指定顺序执行，即遵循队列的入队出队规则
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //定长线程池：
        //可控制线程最大并发数（同时执行的线程数）
        //超出的线程会在队列中等待
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        //队列内元素必须实现Delayed接口，这就意味着你传进去的任务必须先实现Delayed接口。
        // 这个队列接收到任务时，首先先入队，只有达到了指定的延时时间，才会执行任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        scheduledThreadPool.schedule(extendThread,5,TimeUnit.SECONDS);
    }
}
