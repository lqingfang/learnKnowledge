package org.lqf.learn.designModel.singletonModel.exercise02;

public class Test {
    public static void main(String[] args) {
        Triple instance01 = Triple.getInstance(0);
        System.out.println(instance01);
        Triple instance02 = Triple.getInstance(1);
        System.out.println(instance02);
        Triple instance03 = Triple.getInstance(2);
        System.out.println(instance03);
    }
}
