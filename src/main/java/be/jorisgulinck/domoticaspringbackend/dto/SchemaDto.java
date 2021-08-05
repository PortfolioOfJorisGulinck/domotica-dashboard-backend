package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.ServiceType;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;

public class SchemaDto {

    private int id;
    private ServiceType serviceType;
    private String amount;
    private String start;
    private String end;
    private Room room;

    public SchemaDto(int id, ServiceType serviceType, String amount, String start, String end, Room room) {
        this.id = id;
        this.serviceType = serviceType;
        this.amount = amount;
        this.start = start;
        this.end = end;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getService() {
        return serviceType;
    }

    public void setService(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
