package org.lqf.learn.designModel.singletonModel.example;

public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("first new Singlen");
    }
    public static Singleton getInstance() {
        return singleton;
    }


}
