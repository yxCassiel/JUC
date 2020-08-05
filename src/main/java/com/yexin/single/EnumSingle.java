package com.yexin.single;

import java.lang.reflect.Constructor;

/**
 * @author yexin
 * @date 2020-07-31 14:18
 */
public enum  EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }


}

class Test{
    public static void main(String[] args) throws Exception {
        EnumSingle instence1 = EnumSingle.INSTANCE;

        EnumSingle instence2 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class );

        declaredConstructor.setAccessible(true);
        EnumSingle instance = declaredConstructor.newInstance();


        System.out.println(instance);
    }


}
