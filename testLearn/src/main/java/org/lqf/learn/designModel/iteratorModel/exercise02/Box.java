package org.lqf.learn.designModel.iteratorModel.exercise02;


public class Box implements Collec{
    private Fruit[] fruits;

    private int index=0;

    public Box(int max) {
        this.fruits = new Fruit[max];
    }

    public int getLength() {
        return fruits.length;
    }
    public void add(Fruit fruit) {
        fruits[index] = fruit;
        index++;
    }
    public Fruit getAt(int index) {
        return fruits[index];
    }
    public OneByO oneByO() {
        return new BoxIterator(this);
    }
}
