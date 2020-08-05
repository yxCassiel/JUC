package com.yexin.function;

import java.util.function.Consumer;

/**
 * @author yexin
 * @date 2020-07-30 10:52
 */
public class Demo03 {

    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        Consumer<String> consumer = str -> {
            System.out.println(str);
        };

        consumer.accept("hello");
    }
}
