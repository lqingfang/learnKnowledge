package org.lqf.learn.designModel.commandModel;

public class OrderBuy implements Order {
    private Stock stock;

    public OrderBuy(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();
    }
}
