package org.lqf.learn.designModel.decoratorModel.simple;

public class ActionAnimal extends Animal {
    private String str;

    public ActionAnimal(String str) {
        this.str = str;
    }

    public void say() {
        System.out.println(str+":say");
    }

    public void run() {
        System.out.println(str+":run");
    }
}
