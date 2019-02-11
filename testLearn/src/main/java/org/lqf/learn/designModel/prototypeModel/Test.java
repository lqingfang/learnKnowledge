package org.lqf.learn.designModel.prototypeModel;

import org.lqf.learn.designModel.prototypeModel.framework.Manager;
import org.lqf.learn.designModel.prototypeModel.framework.Product;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Manager manager = new Manager();
        Product ep = new EntityProduct();
        manager.register("a",ep);
        Product a = manager.getProduct("a");
        a.use();
    }
}
