package org.lqf.learn.designModel.bridgeModel;

public class Test {
    public static void main(String[] args) {
        Display d = new Display(new StringDisplayImpl("hello"));
        Display d1 = new CountDisplay(new StringDisplayImpl("wander"));
        CountDisplay d2 = new CountDisplay(new StringDisplayImpl("world"));
        d.disPrint();
        d1.disPrint();
        d2.countPrint(5);
    }
}
