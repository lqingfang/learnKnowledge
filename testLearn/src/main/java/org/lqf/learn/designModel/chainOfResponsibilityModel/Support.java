package org.lqf.learn.designModel.chainOfResponsibilityModel;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support support) {
        this.next = support;
        return next;
    }
    public final void step(Trouble trouble) {
        if(resolve(trouble)) {
            System.out.println(trouble.getNum()+" is resolve by "+ this.name);
        }else if(null != next){
            next.step(trouble);
        }else {
            System.out.println(trouble.getNum()+" can not resolve");
        }
    }

    protected abstract boolean resolve(Trouble trouble);
}
