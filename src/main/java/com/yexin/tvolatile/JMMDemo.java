package com.yexin.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @author yexin
 * @date 2020-07-30 16:12
 */
public class JMMDemo {


    private volatile static int num = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while (num== 0){

            }
        }).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num=1;
        System.out.println(num );
    }
}
