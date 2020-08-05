package com.yexin.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-23 11:02
 * 信号量
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //线程数量，停车位,限流的时候会用到
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i <6; i++) {
            new Thread(()->{


                try {
                    semaphore.acquire();//获取
                    System.out.println(Thread.currentThread().getName()+"得到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }
                System.out.println("+++++++++++++++++++");
            },String.valueOf(i)).start();
        }
    }


}
