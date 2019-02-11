package org.lqf.learn.designModel.commandModel;

import java.util.ArrayList;
import java.util.List;

public class CommondColl {
    private List<Order> orders = new ArrayList<Order>();
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void orderExecute() {
        for (Order o :orders) {
            o.execute();
        }
        orders.clear();
    }
}
