package org.lqf.learn.threadLocalKnowlege.threadVariableContainer;

public class  ClientThread extends Thread {
    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i=0;i<4;i++) {
            System.out.println(Thread.currentThread().getName()+"=>"+sequence.getNum());
        }
    }
}
