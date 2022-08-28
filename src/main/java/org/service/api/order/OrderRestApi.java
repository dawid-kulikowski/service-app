package org.service.api.order;

import org.service.model.Order;
import org.service.repository.exception.ClientIdException;
import org.service.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestApi implements OrderApi {

    private OrderService orderService;

    public OrderRestApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody OrderDTO orderDTO) {

        try {
            addOrder(orderDTO.createOrder(), orderDTO.getClientId());
        } catch (ClientIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {

        return ResponseEntity.ok(getAllOrders());
    }

    @PutMapping(path = "/nextStatus/{orderId}")
    public ResponseEntity<Integer> changeToNextStatus(@PathVariable Integer orderId) {
        orderService.changeToNextStatus(orderId);

        return ResponseEntity.ok(orderId);
    }

    @Override
    public void addOrder(Order order, Integer clientId) throws ClientIdException {
        orderService.addOrder(order, clientId);
    }

    @Override
    public void changeToNextStatus(Order order) {

    }

    @Override
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
