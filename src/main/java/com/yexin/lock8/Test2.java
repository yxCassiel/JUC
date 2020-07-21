package com.yexin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-21 15:48
 */
public class Test2 {

    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(() -> {
            phone1.sendSms();
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

class Phone2 {

    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public synchronized void call() {
        System.out.println("打电话");
    }


    public  void hello() {
        System.out.println("hello");
    }

}
