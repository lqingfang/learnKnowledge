package org.lqf.learn.iocTheory;

public class Client {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("org.lqf.learn.iocTheory.Apple");
        if(null !=f){
            f.eat();
        }
    }
}
