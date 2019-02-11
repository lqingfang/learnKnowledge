package org.lqf.learn.designModel.factoryModel.idcard;

import org.lqf.learn.designModel.factoryModel.framework.Product;


public class IDCard extends Product {
    private String owner;
    private int num;

    IDCard(String owner,int num) {
        this.owner = owner;
        this.num = num;
        System.out.println("制作"+owner+"的ID卡。"+"-----"+"编号："+num);
    }

    public void use() {
        System.out.println("使用"+owner+"的ID卡。"+"-----"+"编号："+num);
    }

    public String getOwner() {
        return owner;
    }
}
