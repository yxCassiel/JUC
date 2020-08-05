package com.yexin.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author yexin
 * @date 2020-07-30 11:22
 *
 * 3000   6000（ForkJoin）  9000 (Stream 并行流)
 */
public class forkjoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private Long temp = 10000L;

    public forkjoinDemo(Long start,Long end)
    {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {

        if ((end-start)>temp)
        {
            long middle = (start+end)/2;
            forkjoinDemo task = new forkjoinDemo(start, middle);
            task.fork();
            forkjoinDemo task1 = new forkjoinDemo(middle+1, end);
            task1.fork();

            return task.join()+task1.join();
        }else
        {
            Long num = 0L;
            for (Long i = start; i <= end; i++) {
                num+=i;
            }
            return num;

        }

    }
}
