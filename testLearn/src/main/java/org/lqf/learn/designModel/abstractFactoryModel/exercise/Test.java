package org.lqf.learn.designModel.abstractFactoryModel.exercise;

import org.lqf.learn.designModel.abstractFactoryModel.exercise.factory.Factory;
import org.lqf.learn.designModel.abstractFactoryModel.exercise.foodFactory.SingleFactory;

public class Test {
    public static void main(String[] args) {
        Factory factory = new SingleFactory();
        factory.createPizza().create();
    }
}
