package org.lqf.learn.designModel.commandModel;

public class Stock {
    private String name = "ABC";
    private int quantity = 10;
    public void buy() {
        System.out.println("buy-"+name+"-"+quantity);
    }
    public void sell() {
        System.out.println("sell-"+name+"-"+quantity);
    }
}
