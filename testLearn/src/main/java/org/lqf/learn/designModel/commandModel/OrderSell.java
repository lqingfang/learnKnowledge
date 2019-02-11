package org.lqf.learn.designModel.commandModel;

public class OrderSell implements Order{
    private Stock stock;

    public OrderSell(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.sell();
    }
}
