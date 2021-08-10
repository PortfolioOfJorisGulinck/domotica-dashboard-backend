package be.jorisgulinck.domoticaspringbackend.domain.models.service;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;

import javax.persistence.*;

@Entity
@Table(name = "automation_services")
public class AutomationService {

    @Id
    @Column(name = "automation_service_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_type")
    private ServiceType serviceType;

    @Column(name = "service_value")
    private String value;

    @ManyToOne
    private Room room;

    @OneToOne
    private Schema schema;

    public AutomationService() {
    }

    public AutomationService(int id, ServiceType serviceType, String value, Room room) {
        this.id = id;
        this.serviceType = serviceType;
        this.value = value;
        this.room = room;
    }

    public AutomationService(int id, ServiceType serviceType, String value, Schema schema) {
        this.id = id;
        this.serviceType = serviceType;
        this.value = value;
        this.schema = schema;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }
}
