package org.lqf.learn.designModel.prototypeModel.framework;

import java.util.HashMap;

public class Manager {
    private HashMap products = new HashMap();
    public void register(String s,Product p) {
        products.put(s,p);
    }
    public Product getProduct(String s) throws CloneNotSupportedException {
        Product p = (Product) products.get(s);
        return p.creatClone();
    }
}
