package org.lqf.learn.designModel.decoratorModel.simple;

public abstract class Animal {
    public abstract void say();
    public abstract void run();

    public void play(){
        say();
        run();
    }
}
