package org.lqf.learn.designModel.bridgeModel;

public class Display {
    private DisplayImpl disPlayImpl;

    public Display(DisplayImpl disPlayImpl) {
        this.disPlayImpl = disPlayImpl;
    }
    public void open() {
        disPlayImpl.rawOpen();
    }
    public void print() {
        disPlayImpl.rawPrint();
    }
    public void close() {
        disPlayImpl.rawClose();
    }
    public void disPrint(){
        open();
        print();
        close();
    }
}
