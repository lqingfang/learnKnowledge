package org.lqf.learn.designModel.iteratorModel.exercise02;

public class BoxIterator implements OneByO {
    private Box box;
    private int index;
    public BoxIterator(Box box) {
        this.box = box;
        this.index = 0;
    }

    public boolean hasNext() {
        if(index<box.getLength()){
            return true;
        }
        return false;
    }


    public Fruit next() {

        return box.getAt(index++);
    }
}
