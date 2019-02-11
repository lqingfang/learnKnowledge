package org.lqf.learn.designModel.singletonModel.exercise;

public class TicketMaker {
    private int ticket = 1000;

    private static TicketMaker ticketMaker = new TicketMaker();
    private TicketMaker() {
        System.out.println("first");
    }

    public static TicketMaker getIntance() {
        return ticketMaker;
    }
    public synchronized int getNextTicetNumber() {
        return ticket++;
    }
}
