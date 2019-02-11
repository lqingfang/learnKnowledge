package org.lqf.learn.designModel.commandModel;

public class Test {
    public static void main(String[] args) {
        Stock stock = new Stock();
        OrderBuy orderBuy = new OrderBuy(stock);
        OrderSell orderSell = new OrderSell(stock);

        CommondColl commondColl = new CommondColl();
        commondColl.addOrder(orderBuy);
        commondColl.addOrder(orderSell);

        commondColl.orderExecute();
    }
}
