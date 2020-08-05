package com.yexin.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author yexin
 * @date 2020-07-31 14:33
 */
public class CASDemo {


    public static void main(String[] args) {

        /*AtomicInteger atomicInteger = new AtomicInteger(2020);

        //    public final boolean compareAndSet(int expect, int update) {
        // 跟新  期望
        // 如果期望子达到了  那么就更新  否则不更新
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());
*/



        //正常在业务操作  这里使用的是一对像
        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(1, 1);

        new Thread(()->{
            int stamp = integerAtomicStampedReference.getStamp();
            System.out.println("a1---"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            integerAtomicStampedReference.compareAndSet(1,2,
                    integerAtomicStampedReference.getStamp(),integerAtomicStampedReference.getStamp()+1);


            System.out.println("a2---"+integerAtomicStampedReference.getStamp());


            integerAtomicStampedReference.compareAndSet(2,1,
                    integerAtomicStampedReference.getStamp(),integerAtomicStampedReference.getStamp()+1);

            System.out.println("a3---"+integerAtomicStampedReference.getStamp());



        },"a").start();

        new Thread(()->{

            int stamp = integerAtomicStampedReference.getStamp();
            System.out.println("b1---"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            integerAtomicStampedReference.compareAndSet(1,6,stamp,stamp+1);


            System.out.println("b2---"+integerAtomicStampedReference.getStamp());

        },"b").start();
    }
}
