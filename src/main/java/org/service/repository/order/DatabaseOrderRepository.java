package org.service.repository.order;

import org.service.model.Client;
import org.service.model.Device;
import org.service.model.DeviceType;
import org.service.model.Order;
import org.service.model.exception.ClientValidationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseOrderRepository implements OrderRepository {

    private static final String INSERT_ORDER_SQL = """
            INSERT INTO service_order (device_type, client_id)
            VALUES (?, ?)
            """;

    private static final String GET_ALL_ORDERS_SQL = """
            SELECT c.name,
            c.surname,
            c.phone_number,
            c.second_phone_number,
            c.email,
            s.order_id,
            s.device_type
            FROM service.client c
            INNER JOIN service.service_order s
            ON c.client_id = s.client_id
            """;

    private final JdbcTemplate jdbcTemplate;

    public DatabaseOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addOrder(Order order) {
        jdbcTemplate.update(INSERT_ORDER_SQL,
                order.getDevice().getDeviceType().name(),
                order.getClient().getClientId());
    }

    @Override
    public List<Order> getAllOrders() {
        return jdbcTemplate.query(GET_ALL_ORDERS_SQL, new BeanPropertyRowMapper<>(OrderEntity.class))
                .stream()
                .map(orderEntity -> {
                    try {
                        return getOrder(orderEntity);
                    } catch (ClientValidationException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    private static Order getOrder(OrderEntity orderEntity) throws ClientValidationException {
        return new Order(
                orderEntity.getOrderId(),
                new Client(
                        orderEntity.getName(),
                        orderEntity.getSurname(),
                        orderEntity.getPhoneNumber(),
                        null,
                        null),
                new Device(DeviceType.valueOf(orderEntity.getDeviceType()),
                        null,
                        null,
                        null,
                        null),
                null,
                null,
                false,
                0d
        );
    }
}
