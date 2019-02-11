package org.lqf.learn.designModel.iteratorModel.exercise;

import java.util.ArrayList;

public class BoxWithPicture implements Gather{
    private ArrayList<Picture> pictures;

    public BoxWithPicture(int i) {
        this.pictures = new ArrayList<Picture>(i);
    }


    public void addPicture(Picture p) {
        pictures.add(p);
    }
    public Picture getPicture(int i){
        return (Picture) pictures.get(i);
    }
    public int length(){
        return pictures.size();
    }
    public OneByOne oneByOne() {
        return new BoxWithPictureOneByOne(this);
    }
}
