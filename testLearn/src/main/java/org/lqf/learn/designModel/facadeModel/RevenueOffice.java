package org.lqf.learn.designModel.facadeModel;

public class RevenueOffice implements Executive {
    public void approve() {
        System.out.println("税务局审批通过，定时会去收税");
    }
}
