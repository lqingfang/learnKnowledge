package org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory;

import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Hamburger;

public class FamilyHamburger implements Hamburger {
    public void create() {
        System.out.println("家庭汉堡包");
    }
}
