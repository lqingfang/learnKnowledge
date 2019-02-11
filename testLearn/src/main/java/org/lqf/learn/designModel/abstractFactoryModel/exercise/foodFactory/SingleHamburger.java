package org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory;

import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Hamburger;

public class SingleHamburger implements Hamburger {
    public void create() {
        System.out.println("单人汉堡包");
    }
}
