package com.yexin.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yexin
 * @date 2020-07-31 16:31
 */
public class SpinlockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //枷锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==>mylock");

        while (!atomicReference.compareAndSet(null,thread)) {

        }


    }


    //解锁

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "==>myUnLock");
        atomicReference.compareAndSet(thread,null);

    }


}
