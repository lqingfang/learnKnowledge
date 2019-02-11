package org.lqf.learn.designModel.builderModel.example;

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
