package org.service.model;

import java.time.LocalDateTime;

import static org.service.model.OrderStatus.IN_ORDER;

public class Order {
    private final int orderId;
    private final Client client;
    private final Device device;
    private final String orderDesc;
    private final String repairDiagnosis;
    private final OrderStatus orderStatus;
    private final double estimatedPrice;
    private final double finalPrice;
    private final LocalDateTime orderReceiveDate;

    public Order(int orderId,
                 Client client,
                 Device device,
                 String orderDesc,
                 String repairDiagnosis,
                 double estimatedPrice,
                 double finalPrice) {

        this.orderId = orderId;
        this.client = client;
        this.device = device;
        this.orderDesc = orderDesc;
        this.repairDiagnosis = repairDiagnosis;
        this.orderStatus = IN_ORDER;
        this.estimatedPrice = estimatedPrice;
        this.finalPrice = finalPrice;
        this.orderReceiveDate = LocalDateTime.now();
    }
}
