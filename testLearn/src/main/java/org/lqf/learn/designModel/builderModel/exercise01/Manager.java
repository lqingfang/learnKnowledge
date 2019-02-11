package org.lqf.learn.designModel.builderModel.exercise01;

import org.lqf.learn.designModel.builderModel.example.Animal;

public class Manager {
    private Animal animal;
    public Manager(Animal animal) {
        this.animal = animal;
    }

    public void construct(){
        animal.sayMorning("morning!");
        animal.sayAfternoon("afternoon!");
        animal.sayEvening("eve!");
    }
}
