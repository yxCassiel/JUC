package com.yexin.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yexin
 * @date 2020-07-23 10:57
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("chenggong");
        });


        for (int i = 0; i < 7; i++) {
            final int temp =i;
            //lambda 能操作到i
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"jkhj"+temp+"heelo");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
