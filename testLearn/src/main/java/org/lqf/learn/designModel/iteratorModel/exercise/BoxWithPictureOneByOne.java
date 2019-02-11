package org.lqf.learn.designModel.iteratorModel.exercise;

public class BoxWithPictureOneByOne implements OneByOne{
    private BoxWithPicture boxWithPicture;

    private int last;

    public BoxWithPictureOneByOne(BoxWithPicture boxWithPicture) {
        this.boxWithPicture = boxWithPicture;
        this.last = 0;
    }

    public boolean hasNext() {
        if(last < boxWithPicture.length()) {
            return true;
        }
        return false;
    }

    public Object next() {
        Object o =boxWithPicture.getPicture(last);
        last++;
        return o;
    }
}
