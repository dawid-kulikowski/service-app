package org.service.model;

public class Device {
    private DeviceType deviceType;
    private String brand;
    private String model;
    private String visualCondition;

    public Device(DeviceType deviceType,
                  String brand,
                  String model,
                  String visualCondition) {
        this.deviceType = deviceType;
        this.brand = brand;
        this.model = model;
        this.visualCondition = visualCondition;
    }
}
