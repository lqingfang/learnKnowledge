package org.lqf.learn.designModel.facadeModel;

public class Test {
    public static void main(String[] args) {
        System.out.println("开始办理行政手续。。。");
        ApproveFacade.wholeApprove();
        System.out.println("恭喜，行政手续办理完成。");
    }
}
