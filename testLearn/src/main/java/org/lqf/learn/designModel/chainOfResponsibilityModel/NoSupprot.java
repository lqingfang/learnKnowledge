package org.lqf.learn.designModel.chainOfResponsibilityModel;

public class NoSupprot extends Support {
    public NoSupprot(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
