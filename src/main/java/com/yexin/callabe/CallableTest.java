package com.yexin.callabe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yexin
 * @date 2020-07-23 10:21
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread(runnable).start();
//        new Thread(futuretask).start();
//        new Thread(futuretask<callable>).start();

        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//结果会被缓存，效率高

        Object o = (Integer)futureTask.get();//get方法可能会产生阻塞！把它放到最后一行，或者使用异步通讯来处理
        System.out.println(o);

    }
}


class MyThread implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}