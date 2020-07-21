package com.yexin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-21 15:48
 * 静态 一家在就有了，锁的是Class phone3 的对象
 */
public class Test3 {

    public static void main(String[] args) {
        //两个对象使用的类模版只有一个
        Phone3 phone = new Phone3();
        Phone3 phone2 = new Phone3();


        new Thread(() -> {
            phone.sendSms();
        }, "A").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        }, "B").start();

    }
}

class Phone3 {

    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public static synchronized void call() {
        System.out.println("打电话");
    }



}
