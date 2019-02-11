package org.lqf.learn.designModel.prototypeModel;

import org.lqf.learn.designModel.prototypeModel.framework.Product;

public class EntityProduct implements Product {

    public EntityProduct() {
    }

    public void use() {
        System.out.println("EntityProduct");
    }


    public Product creatClone() throws CloneNotSupportedException {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
