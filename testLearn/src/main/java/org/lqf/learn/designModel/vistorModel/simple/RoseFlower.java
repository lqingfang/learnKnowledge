package org.lqf.learn.designModel.vistorModel.simple;

public class RoseFlower extends Flower {

    public RoseFlower() {
        this.flowerName = "rose";
        this.num = 1;
        this.price = 6;
    }

    public RoseFlower(int num) {
        this();
        this.num = num;
    }
    public void acceptChoice(Visitorr visitorr) {
        visitorr.choice(this);
    }
}
