package org.service.repository.order;

import org.service.model.Order;

import java.util.List;

public interface OrderRepository {

    void addOrder(Order order);

    List<Order> getAllOrders();

}
