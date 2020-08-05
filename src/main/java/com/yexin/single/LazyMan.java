package com.yexin.single;

import org.omg.SendingContext.RunTime;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author yexin
 * @date 2020-07-31 13:56
 */
public class LazyMan {

    private static boolean yexin = false;

    private LazyMan()
    {
        synchronized (LazyMan.class)
        {
            if(yexin==false)
            {
                yexin =true;
            }else{
                throw new RuntimeException("破坏");
            }
//            if (lazyMan!=null)
//            {
//                throw new RuntimeException("破坏");
//            }
        }
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private volatile static LazyMan lazyMan;


    //双重检测  DCL懒汉是
    public static LazyMan getInstance(){

        if(lazyMan==null)
        {
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();
                    //不是一个院子行操作
                    /**
                     * 分配内存空间
                     * 执行构造方便 初始化对象
                     * 把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        LazyMan instance = LazyMan.getInstance();


        Field yexin = LazyMan.class.getDeclaredField("yexin");
        yexin.setAccessible(true);



        Constructor<LazyMan> declaredConstructors = LazyMan.class.getDeclaredConstructor(null);

        declaredConstructors.setAccessible(true);
        LazyMan instance1 = declaredConstructors.newInstance();

        yexin.set(instance1,false);


        LazyMan instance2 = declaredConstructors.newInstance();

        System.out.println(instance2==instance1);
    }
}
