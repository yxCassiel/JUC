package com.yexin.function;

import java.util.function.Supplier;

/**
 * @author yexin
 * @date 2020-07-30 10:52
 */
public class Demo04 {

    public static void main(String[] args) {

//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//
//                return 1024;
//            }
//        };


        Supplier<Integer> supplier = ()->{return 1024;};
        System.out.println(supplier.get());
    }
}
