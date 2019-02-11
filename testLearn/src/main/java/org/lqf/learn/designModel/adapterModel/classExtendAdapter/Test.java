package org.lqf.learn.designModel.adapterModel.classExtendAdapter;

public class Test {
    public static void main(String[] args) {
        Print p = new PrintBanner("hello");
        p.printWeak();
        p.printStrong();
    }
}
