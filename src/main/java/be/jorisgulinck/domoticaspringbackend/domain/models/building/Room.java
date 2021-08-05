package be.jorisgulinck.domoticaspringbackend.domain.models.building;

import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import be.jorisgulinck.domoticaspringbackend.domain.models.service.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @Column(name = "room_id")
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "room")
    private List<Service> services;

    @OneToOne
    private Dimension dimension;

    @OneToOne
    private Position position;

    @ManyToOne
    private Floor floor;

    @OneToMany(mappedBy = "room")
    private List<Schema> schemes;

    public Room() {
    }

    public Room(int id, String name, String description, List<Service> services, Dimension dimension, Position position, Floor floor, List<Schema> schemes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.services = services;
        this.dimension = dimension;
        this.position = position;
        this.floor = floor;
        this.schemes = schemes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public List<Schema> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<Schema> schemes) {
        this.schemes = schemes;
    }
}
