package org.lqf.learn.currentPac.jucDay01;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    Semaphore semaphore=new Semaphore(5);
    /**
     * 假设并发只能为5个
     */
    public void pay(){
        try {
            //在 semaphore.acquire() 和 semaphore.release()之间的代码，同一时刻只允许指定个数的线程进入！
            semaphore.acquire();
            System.out.println("------");
            Thread.sleep(2000);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemaphoreTest ts=new SemaphoreTest();
        for (int i=0;i<10;i++){
            new Thread(()->{
                ts.pay();
            },"线程"+i).start();
        }
    }
}
