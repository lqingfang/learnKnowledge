package org.lqf.learn.designModel.decoratorModel.simple;

public class LineBorder extends Border {
    public LineBorder(Animal animal) {
        super(animal);
    }

    public void say() {
        System.out.println("------");
        animal.say();
        System.out.println("------");
    }

    public void run() {
        System.out.println("*****");
        animal.run();
        System.out.println("*****");
    }
}
