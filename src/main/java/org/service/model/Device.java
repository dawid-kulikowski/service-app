package org.service.model;

public class Device {
    private DeviceType deviceType;
    private String brand;
    private String model;
    private String visualCondition;
    private String devicePassword; //TODO Encrypt password

    public Device(DeviceType deviceType,
                  String brand,
                  String model,
                  String visualCondition, String devicePassword) {
        this.deviceType = deviceType;
        this.brand = brand;
        this.model = model;
        this.visualCondition = visualCondition;
        this.devicePassword = devicePassword;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getVisualCondition() {
        return visualCondition;
    }

    public String getDevicePassword() {
        return devicePassword;
    }
}
