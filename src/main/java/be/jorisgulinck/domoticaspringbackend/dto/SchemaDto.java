package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationDevice;

public class SchemaDto {

    private int id;
    private String start;
    private String end;
    private AutomationDevice automationDevice;
    private int roomId;

    public SchemaDto() {
    }

    public SchemaDto(int id, String start, String end, AutomationDevice automationDevice, int roomId) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.automationDevice = automationDevice;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public AutomationDevice getAutomationDevice() {
        return automationDevice;
    }

    public void setAutomationDevice(AutomationDevice automationDevice) {
        this.automationDevice = automationDevice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
