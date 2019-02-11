package org.lqf.learn.designModel.adapterModel.classExtendAdapter;

public class Banner {
    String str;

    public Banner(String str) {
        this.str = str;
    }
    public void showWithParen() {
        System.out.println("("+str+")");
    }
    public void showWithAster() {
        System.out.println("*"+str+"*");
    }
}
