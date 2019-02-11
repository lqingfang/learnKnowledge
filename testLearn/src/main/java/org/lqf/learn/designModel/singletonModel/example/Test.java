package org.lqf.learn.designModel.singletonModel.example;

public class Test {
    public static void main(String[] args) {
        Singleton singleton01 = Singleton.getInstance();
        Singleton singleton02 = Singleton.getInstance();
        if(singleton01 == singleton02) {
            System.out.println("same");
        }else {
            System.out.println("not same");
        }

    }
}
