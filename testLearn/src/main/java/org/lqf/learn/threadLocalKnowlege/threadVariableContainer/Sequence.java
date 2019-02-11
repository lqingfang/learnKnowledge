package org.lqf.learn.threadLocalKnowlege.threadVariableContainer;

public class Sequence{

    private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 0;
        }
    };
    public int getNum() {
        numberContainer.set(numberContainer.get()+1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        ClientThread t1 = new ClientThread(sequence);
        ClientThread t2 = new ClientThread(sequence);
        ClientThread t3 = new ClientThread(sequence);
        t1.start();
        t2.start();
        t3.start();

    }
}
