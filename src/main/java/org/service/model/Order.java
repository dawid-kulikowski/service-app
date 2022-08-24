package org.service.model;

import java.time.LocalDateTime;

import static org.service.model.OrderStatus.IN_ORDER;

public class Order {
    private int orderId;
    private Client client;
    private final Device device;
    private final String orderDesc;
    private String repairDiagnosis;
    private OrderStatus orderStatus;
    private boolean charger;
    private double price;
    private final LocalDateTime orderReceiveDate;

    public Order(
            Device device,
            String orderDesc,
            String repairDiagnosis,
            boolean charger,
            double price) {

        this.device = device;
        this.orderDesc = orderDesc;
        this.repairDiagnosis = repairDiagnosis;
        this.orderStatus = IN_ORDER;
        this.charger = charger;
        this.price = price;
        this.orderReceiveDate = LocalDateTime.now();
    }

    public Order(int orderId,
                 Client client,
                 Device device,
                 String orderDesc,
                 String repairDiagnosis,
                 boolean charger,
                 double price) {

        this(device, orderDesc, repairDiagnosis, charger, price);
        this.orderId = orderId;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public int getOrderId() {
        return orderId;
    }

    public Device getDevice() {
        return device;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public String getRepairDiagnosis() {
        return repairDiagnosis;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public boolean isCharger() {
        return charger;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getOrderReceiveDate() {
        return orderReceiveDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
