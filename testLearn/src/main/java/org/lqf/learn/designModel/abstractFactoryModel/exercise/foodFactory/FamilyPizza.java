package org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory;

import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Pizza;

public class FamilyPizza implements Pizza {
    public void create() {
        System.out.println("家庭披萨");
    }
}
