package org.lqf.learn.designModel.iteratorModel.exercise02;

public class Test {
    public static void main(String[] args) {
        Box box = new Box(2);
        box.add(new Fruit("apple"));
        box.add(new Fruit("balana"));
        OneByO oneByO = box.oneByO();
        while (oneByO.hasNext()) {
            System.out.println(((Fruit)oneByO.next()).getName());
        }
    }
}
