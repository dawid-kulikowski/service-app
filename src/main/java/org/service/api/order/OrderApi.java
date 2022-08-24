package org.service.api.order;

import org.service.model.Order;
import org.service.repository.exception.ClientIdException;

import java.util.List;

public interface OrderApi {

    void addOrder(Order order, Integer clientId) throws ClientIdException;

    void changeToNextStatus(Order order);

    List<Order> getAllOrders();
}
