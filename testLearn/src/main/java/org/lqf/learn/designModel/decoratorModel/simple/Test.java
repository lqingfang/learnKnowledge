package org.lqf.learn.designModel.decoratorModel.simple;

public class Test {
    public static void main(String[] args) {
        Animal animal = new LineBorder(new ActionAnimal("dog"));
        animal.play();
    }
}
