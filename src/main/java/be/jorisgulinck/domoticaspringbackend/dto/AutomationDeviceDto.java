package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.device.DeviceType;

public class AutomationDeviceDto {

    private int id;
    private DeviceType deviceType;
    private String value;
    private int roomId;

    public AutomationDeviceDto() {
    }

    public AutomationDeviceDto(int id, DeviceType deviceType, String value, int roomId) {
        this.id = id;
        this.deviceType = deviceType;
        this.value = value;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DeviceType getServiceType() {
        return deviceType;
    }

    public void setServiceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
