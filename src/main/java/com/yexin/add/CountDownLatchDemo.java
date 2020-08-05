package com.yexin.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author yexin
 * @date 2020-07-23 10:47
 * 计数器
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =  new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();//数量减1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后向下执行


        System.out.println("close");

    }

}
