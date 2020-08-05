package com.yexin.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-30 14:59
 */
public class Demo01 {




    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync=>void");
//        });
//
//        System.out.println("1111");
//
//        completableFuture.get();//阻塞获取执行结果



        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{

            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            int i=10/0;
            return 1024;

        });

        completableFuture.whenComplete((t,u)->{
            System.out.println(t); //正确的返回值
            System.out.println(u); //错误的信息
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233; // 错误的返回结果
        }).get();
    }

}
