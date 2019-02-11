package org.lqf.learn.designModel.bridgeModel;

public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl disPlayImpl) {
        super(disPlayImpl);
    }
    public void countPrint(int times) {
        open();
        for(int i=0;i<times;i++) {
           print();
        }
        close();
    }
}
