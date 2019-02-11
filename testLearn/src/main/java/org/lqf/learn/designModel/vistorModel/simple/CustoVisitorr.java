package org.lqf.learn.designModel.vistorModel.simple;

public class CustoVisitorr implements  Visitorr{
    public void choice(Flower flower) {
        Flower flower1 = ((Flower)flower);
        System.out.println(flower1.getFlowerName()+":"+flower1.getNum()+":"+flower1.getPrice());
    }
}
