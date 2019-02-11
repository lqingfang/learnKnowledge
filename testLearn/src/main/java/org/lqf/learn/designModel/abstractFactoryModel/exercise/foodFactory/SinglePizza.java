package org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory;

import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Pizza;

public class SinglePizza implements Pizza {
    public void create() {
        System.out.println("单人披萨");
    }
}
