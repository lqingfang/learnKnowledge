package org.lqf.learn.designModel.proxyModel;

public class PrinttProxy implements Printt {
    private String name;
    private Printt real;

    public PrinttProxy() {
    }

    public PrinttProxy(String name) {
        this.name = name;
    }

    public synchronized void setPrinterName(String name) {
        if(real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    public String getPrinterName() {
        return name;
    }

    public void print(String str) {
        realize();
        real.print(str);
    }

    private synchronized void realize() {
        if(real == null) {
            real = new PrinttImpl(name);
        }
    }
}
