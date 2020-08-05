package com.yexin.lock;


/**
 * @author yexin
 * @date 2020-07-31 16:10
 */
public class Demo1 {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(() -> {
            phone.sms();
        }, "A").start();


        new Thread(() -> {
            phone.sms();
        }, "B").start();


    }
}


class Phone {
    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + "sms");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "call");

    }

}