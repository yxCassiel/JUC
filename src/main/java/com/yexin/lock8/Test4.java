package com.yexin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-21 15:48
 * 一个静态同步方法 ，一个普通同步方法
 */
public class Test4 {

    public static void main(String[] args) {
        //两个对象使用的类模版只有一个
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();


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

class Phone4 {

    //静态同步方法 锁的Class 类模版
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //普通同步方法 锁的是对象
    public synchronized void call() {
        System.out.println("打电话");
    }



}
