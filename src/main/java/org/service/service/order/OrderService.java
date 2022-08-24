package org.service.service.order;

import org.service.model.Client;
import org.service.model.Order;
import org.service.repository.client.ClientRepository;
import org.service.repository.exception.ClientIdException;
import org.service.repository.order.OrderEntity;
import org.service.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    public void addOrder(Order order, Integer clientId) throws ClientIdException {
        Client client = clientRepository.getClientById(clientId);
        order.setClient(client);

        orderRepository.addOrder(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
