package com.yexin.pool;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

/**
 * @author yexin
 * @date 2020-07-27 15:11
 * 线程池3大方法
 */
public class Demo01 {
    public static void main(String[] args) {
//        Executors.newSingleThreadExecutor();//单一线程
//        Executors.newFixedThreadPool(5); // 创建 一个固定的线程池的大小
//        Executors.newCachedThreadPool();//可以伸缩的，遇强则强

        System.out.println(Runtime.getRuntime().availableProcessors());


        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            //z最大承载 Deque+ Max
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
