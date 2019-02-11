package org.lqf.learn.designModel.proxyModel;

public class Test {
    public static void main(String[] args) {
        Printt p = new PrinttProxy("alice");
        System.out.println(p.getPrinterName());
        p.setPrinterName("bo");
        System.out.println(p.getPrinterName());
        p.print("hello");
    }
}
