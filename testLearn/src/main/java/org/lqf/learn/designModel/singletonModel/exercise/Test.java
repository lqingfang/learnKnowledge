package org.lqf.learn.designModel.singletonModel.exercise;

public class Test {
    public static void main(String[] args) {
        TicketMaker ticketMaker01 = TicketMaker.getIntance();
        TicketMaker ticketMaker02 = TicketMaker.getIntance();
        if(ticketMaker01 == ticketMaker02) {
            System.out.println("same");
        }
        System.out.println(ticketMaker02.getNextTicetNumber());
        System.out.println(ticketMaker01.getNextTicetNumber());
    }
}
