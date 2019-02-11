package org.lqf.learn.designModel.observerModel;

import java.util.Random;

public class GeneratorNumImpl extends GeneratorNum {
    private int num;
    public int getNum() {
        return num;
    }
    private Random random = new Random();
    public void execute() {
        num = random.nextInt(50);
        notifyAl();
    }
}
