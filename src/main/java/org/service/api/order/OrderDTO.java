package org.service.api.order;

import org.service.model.Device;
import org.service.model.DeviceType;
import org.service.model.Order;

public class OrderDTO {
    private Integer clientId;
    private String deviceType;
    private String orderDesc;
    private String repairDiagnosis;
    private boolean charger;
    private double price;

    public OrderDTO(Integer clientId,
                    String deviceType,
                    String orderDesc,
                    String repairDiagnosis,
                    boolean charger,
                    double price) {
        this.clientId = clientId;
        this.deviceType = deviceType;
        this.orderDesc = orderDesc;
        this.repairDiagnosis = repairDiagnosis;
        this.charger = charger;
        this.price = price;
    }

    public Order createOrder() {
        Device device = new Device(DeviceType.valueOf(deviceType), null, null, null, null);

        return new Order(device, orderDesc, repairDiagnosis, charger, price);
    }

    public Integer getClientId() {
        return clientId;
    }
}
