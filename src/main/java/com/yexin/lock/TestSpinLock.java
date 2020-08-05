package com.yexin.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-31 17:40
 */
public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo spinlockDemo = new SpinlockDemo();

        new Thread(() -> {
            spinlockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinlockDemo.myUnLock();
            }
        }, "T1").start();


        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            spinlockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinlockDemo.myUnLock();
            }
        }, "T2").start();

    }
}
