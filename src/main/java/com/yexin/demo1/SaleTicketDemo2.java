package com.yexin.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yexin
 * @date 2020-07-16 10:11
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        //并发 多个线程 操作同一个资源类
        Ticket2 ticket = new Ticket2();


        //@FuntionalInterface  jdk1.8  use lamda
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ticket.sale();

            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ticket.sale();
            }
        }, "C").start();

    }

}

class Ticket2 {
    private int number = 1000;

    Lock lock = new ReentrantLock();


    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}


