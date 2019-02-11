package org.lqf.learn.designModel.builderModel.example;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Manager m = new Manager(animal);
        m.construct();
    }
}
