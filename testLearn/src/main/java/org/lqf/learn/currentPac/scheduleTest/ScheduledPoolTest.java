package org.lqf.learn.currentPac.scheduleTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledPoolTest {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("hh:mm:ss");

    public static void main(String[] args) {
        scheduleWithFixedDelay();
    }
    /*
    12:19:03
    12:19:06
    0000000000
    3秒后执行一次
     */
    public static void schedule() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        printTime();
        scheduledThreadPoolExecutor.schedule(new Task(),3,TimeUnit.SECONDS);
    }
    /*
    12:42:01
    12:42:01
    0000000000
    12:42:02
    0000000000
    12:42:03
    0000000000
    12:42:04
    0000000000
    12:42:05
    0000000000
    12:42:06
    0000000000
    12:42:07
    0000000000
    每一秒执行一次
    如果存在延迟，比如第三个线程用了5秒钟，scheduleAtFixedRate是周期固定，
    不会受到这个延迟的影响，每个线程的调度周期在初始化时就已经绝对了，
    是什么时候调度就是什么时候调度，它不会因为上一个线程的调度失效延迟而受到影响。
    */
    public static void scheduleAtFixedRate() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        printTime();
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Task(),0,1,TimeUnit.SECONDS);
    }

    /*
    12:44:05
    12:44:07
    0000000000
    12:44:11
    0000000000
    12:44:15
    0000000000
    12:44:19
    0000000000
    12:44:23
    0000000000
    12:44:27
    0000000000
    每个线程的调度间隔固定
     */
    public static void scheduleWithFixedDelay() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        printTime();
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Task(), 2, 4, TimeUnit.SECONDS);
    }

    static class Task implements Runnable{
        public void run() {
            printTime();
            try {
                System.out.println("0000000000");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void printTime() {
        Date date = new Date();
        System.out.println(FORMAT.format(date));
    }
}
