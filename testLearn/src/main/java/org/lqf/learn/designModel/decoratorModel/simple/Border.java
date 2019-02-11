package org.lqf.learn.designModel.decoratorModel.simple;

public abstract class Border extends Animal {
    protected Animal animal;

    public Border(Animal animal) {
        this.animal = animal;
    }
}
