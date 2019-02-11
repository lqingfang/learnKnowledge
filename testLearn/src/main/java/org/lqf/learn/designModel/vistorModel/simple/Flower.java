package org.lqf.learn.designModel.vistorModel.simple;

public abstract class Flower {
    protected String flowerName;
    protected int num;
    protected int price;
    public abstract void acceptChoice(Visitorr visitorr);

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
