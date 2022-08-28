package org.service.service.order;

import org.service.model.Client;
import org.service.model.Order;
import org.service.model.OrderStatus;
import org.service.repository.client.ClientRepository;
import org.service.repository.exception.ClientIdException;
import org.service.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

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

    public void changeToNextStatus(Integer orderId) {
        Optional<OrderStatus> orderStatus = getAllOrders()
                .stream()
                .filter(order -> order.getOrderId() == orderId)
                .map(Order::getOrderStatus)
                .findFirst();

        if (orderStatus.isPresent()) {
            orderRepository.changeToNextStatus(orderId, orderStatus.get().nextStatus());
        } else {
            throw new RuntimeException(); //TODO
        }
    }
}
