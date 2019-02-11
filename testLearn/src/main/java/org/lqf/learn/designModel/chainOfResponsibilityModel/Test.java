package org.lqf.learn.designModel.chainOfResponsibilityModel;

public class Test {
    public static void main(String[] args) {
        Support noSu = new NoSupprot("Alice");
        Support limSu = new LimitSupport("limiSu",200);
        Support oddSu = new OddSupport("oddSu");

        noSu.setNext(limSu).setNext(oddSu);
        for (int i=0;i<500;i+=55) {
            noSu.step(new Trouble(i));
        }
    }
}
