package org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory;


import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Factory;
import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Hamburger;
import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Pizza;

public class SingleFactory implements Factory {
    public Pizza createPizza() {
        return new SinglePizza();
    }

    public Hamburger createHamburger() {
        return new SingleHamburger();
    }
}
