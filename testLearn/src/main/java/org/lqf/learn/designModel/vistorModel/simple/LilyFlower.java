package org.lqf.learn.designModel.vistorModel.simple;

public class LilyFlower extends Flower {
    public LilyFlower() {
        this.flowerName = "lily";
        this.price = 8;
        this.num = 1;
    }
    public LilyFlower(int num) {
        this();
        this.num = num;
    }

    public void acceptChoice(Visitorr visitorr) {
        visitorr.choice(this);
    }
}
