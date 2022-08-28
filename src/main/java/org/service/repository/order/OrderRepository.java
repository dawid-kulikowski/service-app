package org.service.repository.order;

import org.service.model.Order;
import org.service.model.OrderStatus;

import java.util.List;

public interface OrderRepository {

    void addOrder(Order order);

    List<Order> getAllOrders();

    void changeToNextStatus(Integer orderId, OrderStatus orderStatus);
}
