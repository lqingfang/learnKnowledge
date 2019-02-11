package org.lqf.learn.designModel.chainOfResponsibilityModel;

public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    protected boolean resolve(Trouble trouble) {
        if(trouble.getNum()<limit) {
            return true;
        }else {
            return false;
        }
    }
}
