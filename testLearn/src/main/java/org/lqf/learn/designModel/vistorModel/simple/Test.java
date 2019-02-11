package org.lqf.learn.designModel.vistorModel.simple;

public class Test {
    public static void main(String[] args) {
        BuyFlower buyFlower = new BuyFlower();

        buyFlower.add(new LilyFlower(3));
        buyFlower.add(new RoseFlower(4));
        buyFlower.buy(new CustoVisitorr());
    }
}
