package com.yexin.single;

/**
 * @author yexin
 * @date 2020-07-31 13:51
 */
public class Hungry {


    private byte[] data1 = new byte[1024*1024];

    private Hungry(){

    }

    private final static Hungry HUNGRY   = new Hungry();


    public static Hungry getInstance()
    {
        return HUNGRY;
    }

}
