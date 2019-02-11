package org.lqf.learn.designModel.vistorModel.simple;

import java.util.HashMap;

public class BuyFlower {
    private HashMap<String,Flower> flowerHashMap;

    public BuyFlower() {
        flowerHashMap = new HashMap();
    }

    private int allPrice = 0;
    public void add(Flower flower) {
        flowerHashMap.put(flower.getFlowerName(),flower);
    }

    public void buy(Visitorr visitorr) {
        for(Flower f :flowerHashMap.values()){
            f.acceptChoice(visitorr);
            allPrice += f.getNum() * f.getPrice();
        }
        System.out.println("总价:"+allPrice);
    }
}
