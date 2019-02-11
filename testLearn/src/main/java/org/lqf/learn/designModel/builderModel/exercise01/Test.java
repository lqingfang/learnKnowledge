package org.lqf.learn.designModel.builderModel.exercise01;

import org.lqf.learn.designModel.builderModel.example.Animal;
import org.lqf.learn.designModel.builderModel.example.Dog;
import org.lqf.learn.designModel.builderModel.example.Manager;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Manager m = new Manager(animal);
        m.construct();
    }
}
