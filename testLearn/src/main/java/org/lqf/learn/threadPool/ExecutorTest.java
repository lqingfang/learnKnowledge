package org.lqf.learn.threadPool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,6, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.print("线程池中线程数目："+executor.getPoolSize());
            System.out.print(",队列中等待执行的任务数目："+executor.getQueue().size());
            System.out.println(",已执行完别的任务数目："+executor.getCompletedTaskCount());
        }
    }
}
