package com.yexin.unsafe;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yexin
 * @date 2020-07-21 16:49
 * java.util.ConcurrentModificationException 并发修改异常
 */
public class ListTest {

    public static void main(String[] args) {

        //并发下ArrayList是不安全的
        /**
         * 解决方案：
         * 1。 List<String> list = new Vector<>();
         * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();  JUC并发
         *CopyOnWrite写入时复制，COW  计算机程序设计利于的一种优化策略
         * 多个线程调用时候，list 读取的时候 ，固定的，写入覆盖
         * 在雌蛾入的时候避免覆盖，造成数据的问题
         * 读写分离
         * CopyOnWriteArrayList  比 Vector厉害的地方
         *
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <=100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }

}
