package com.yexin.pc;

/**
 * @author yexin
 * @date 2020-07-16 11:01
 * 线程之间通讯问题，生产者消费者
 */
public class A {
    public static void main(String[] args) {

        Data data =new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();


    }
}


//等待，业务，通知
class Data {
    int number = 0;

    public synchronized void increment() throws InterruptedException {
        if (number != 0) {
            //等待
            this.wait();
        }
        number++;
        //同志其他线程

        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        if (number == 0) {
            this.wait();

        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notifyAll();
    }
}
