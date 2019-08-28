package org.lqf.learn.threadPool;

public class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task："+taskNum);
        try {
            Thread.currentThread().sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task:"+taskNum+"执行完毕");
    }
}