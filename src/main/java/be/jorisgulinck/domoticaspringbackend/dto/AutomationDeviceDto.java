package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.ServiceType;

public class AutomationDeviceDto {

    private int id;
    private ServiceType serviceType;
    private String value;
    private int roomId;

    public AutomationDeviceDto() {
    }

    public AutomationDeviceDto(int id, ServiceType serviceType, String value, int roomId) {
        this.id = id;
        this.serviceType = serviceType;
        this.value = value;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
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
