package org.lqf.learn.designModel.proxyModel;

public class PrinttImpl implements Printt {
    private String name;

    public PrinttImpl() {
        heavyJob();
    }

    public PrinttImpl(String name) {
        this.name = name;
        heavyJob();
    }

    private void heavyJob() {
        System.out.println("0000000000");
    }

    public void setPrinterName(String name) {
        this.name = name;
    }

    public String getPrinterName() {
        return name;
    }

    public void print(String str) {
        System.out.println("=== " + name + " ===");
        System.out.println(str);
    }
}
