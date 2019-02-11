package org.lqf.learn.designModel.iteratorModel.exercise;

public class Test {
    public static void main(String[] args) {
        BoxWithPicture bwp = new BoxWithPicture(4);
        Picture p1 = new Picture("a");
        Picture p2 = new Picture("b");
        Picture p3 = new Picture("c");
        Picture p4 = new Picture("d");
        bwp.addPicture(p1);
        bwp.addPicture(p2);
        bwp.addPicture(p3);
        bwp.addPicture(p4);
        OneByOne oneByOne = bwp.oneByOne();
        while (oneByOne.hasNext()) {
            Picture p = (Picture)oneByOne.next();
            System.out.println(p.getName());
        }
    }
}
