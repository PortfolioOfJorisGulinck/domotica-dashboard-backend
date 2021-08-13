package be.jorisgulinck.domoticaspringbackend.domain.models.domotica;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;

import javax.persistence.*;

@Entity
@Table(name = "schemes")
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schema_id")
    private int id;

    @Column(name = "schema_start")
    private String start;

    @Column(name = "schema_end")
    private String end;

    @OneToOne
    private AutomationDevice automationDevice;

    @ManyToOne
    private Room room;

    public Schema() {
    }

    public Schema(int id, String start, String end, AutomationDevice automationDevice, Room room) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.automationDevice = automationDevice;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AutomationDevice getAutomationDevice() {
        return automationDevice;
    }

    public void setAutomationDevice(AutomationDevice automationDevice) {
        this.automationDevice = automationDevice;
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
