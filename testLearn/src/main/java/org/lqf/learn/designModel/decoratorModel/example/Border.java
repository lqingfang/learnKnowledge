package org.lqf.learn.designModel.decoratorModel.example;

public abstract class Border extends Display{
    protected Display display;

    public Border(Display display) {
        this.display = display;
    }
}
