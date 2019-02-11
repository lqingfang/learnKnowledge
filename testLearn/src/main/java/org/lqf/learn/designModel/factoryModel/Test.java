package org.lqf.learn.designModel.factoryModel;

import org.lqf.learn.designModel.factoryModel.framework.Factory;
import org.lqf.learn.designModel.factoryModel.framework.Product;
import org.lqf.learn.designModel.factoryModel.idcard.IDCardFactory;

public class Test {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product p1 = factory.create("a");
        Product p2 = factory.create("b");
        Product p3 = factory.create("c");
        p1.use();
        p2.use();
        p3.use();
    }
}
