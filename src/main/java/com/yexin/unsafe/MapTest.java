package com.yexin.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yexin
 * @date 2020-07-22 11:27
 */
public class MapTest {

    public static void main(String[] args) {


        Map<String,String> map =new HashMap<>();
        //加载因子，初始化容量
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            }).start();
        }

    }
}
