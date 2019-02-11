package org.lqf.learn.designModel.chainOfResponsibilityModel;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        if(trouble.getNum()%2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
