package be.jorisgulinck.domoticaspringbackend.domain.models.domotica;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.Service;
import be.jorisgulinck.domoticaspringbackend.domain.models.service.ServiceType;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;

import javax.persistence.*;

@Entity
public class Schema {
    @Id
    @Column(name = "schema_id")
    private int id;

    private String start;

    private String end;

    @OneToOne
    private Service service;

    @ManyToOne
    private Room room;

    public Schema() {
    }

    public Schema(int id, String start, String end, Service service, Room room) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.service = service;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
