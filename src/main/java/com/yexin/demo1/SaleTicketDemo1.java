package com.yexin.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-16 09:12
 * 真正的公司重的开发 降低耦合性
 * 线程就是一个单独的资源类，没有热河附属的操作
 * 1。属性 方法
 */
public class SaleTicketDemo1 {


    public static void main(String[] args) {
        //并发 多个线程 操作同一个资源类
        final Ticket ticket = new Ticket();


        //@FuntionalInterface  jdk1.8  use lamda
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                ticket.sale();

            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                ticket.sale();
            }
        },"C").start();

    }

}

class Ticket {
    private int number = 30;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余" + number);
        }
    }


}

