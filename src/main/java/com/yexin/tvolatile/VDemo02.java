package com.yexin.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yexin
 * @date 2020-07-30 16:24
 */
public class VDemo02 {

    private volatile static AtomicInteger num = new AtomicInteger();

    private  static void add() {
        //num++;
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ":" + num);

    }

}
