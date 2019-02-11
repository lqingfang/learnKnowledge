package org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory;

import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Factory;
import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Hamburger;
import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Pizza;

public class FamilyFactory implements Factory {
    public Pizza createPizza() {
        return new FamilyPizza();
    }

    public Hamburger createHamburger() {
        return new FamilyHamburger();
    }
}
