package org.lqf.learn.designModel.facadeModel;

public class ApproveFacade {
    public ApproveFacade() {
    }
    public static void wholeApprove() {
        new HealthOffice().approve();
        new RevenueOffice().approve();
        new SaicOffice().approve();
    }
}
