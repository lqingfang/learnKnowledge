package org.lqf.learn.designModel.factoryModel.idcard;

import org.lqf.learn.designModel.factoryModel.framework.Factory;
import org.lqf.learn.designModel.factoryModel.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    int num = 100;
    protected Product createProduct(String owner) {
        return new IDCard(owner,num++);
    }

    protected void registerProduct(Product product) {
        owners.add(product);
    }
    public List getOwners() {
        return owners;
    }
}
