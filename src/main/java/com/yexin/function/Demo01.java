package com.yexin.function;

import java.util.function.Function;

/**
 * @author yexin
 * @date 2020-07-30 10:44
 * 函数示接口可以用lambda表达式
 */
public class Demo01 {

    public static void main(String[] args) {
//        Function function = new Function<String ,String>() {
//
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };

        Function<String,String> function = (str)->{return str;};

        System.out.println(function.apply("tsd"));
    }
}
