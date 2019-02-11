package org.lqf.learn.designModel.bridgeModel;

public class StringDisplayImpl extends DisplayImpl {
    private String str;
    private int width;

    public StringDisplayImpl(String str) {
        this.str = str;
        this.width = str.getBytes().length;
    }

    public void rawOpen() {
        System.out.println("open");
    }

    public void rawPrint() {
        System.out.println(str+":"+width);
    }

    public void rawClose() {
        System.out.println("close");
    }
}
