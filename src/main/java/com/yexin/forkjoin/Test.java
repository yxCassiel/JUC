package com.yexin.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author yexin
 * @date 2020-07-30 13:59
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1(); 7717
//        test2(); 6262
//        test3(); 543

    }

    public static void test1() {
        long start = System.currentTimeMillis();

        Long num = 0L;
        for (Long i = 0L; i <= 10_0000_0000L; i++) {
            num += i;
        }

        long end = System.currentTimeMillis();
        System.out.println("sum" + num + "时间" + (end - start));
    }


    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new forkjoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum" + sum + "时间" + (end - start));
    }


    public static void test3() {
        long start = System.currentTimeMillis();

        //stream 并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum" + sum + "时间" + (end - start));
    }


}
