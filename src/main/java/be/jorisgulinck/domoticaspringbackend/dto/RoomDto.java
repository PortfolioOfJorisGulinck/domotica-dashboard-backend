package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;

import java.util.List;

public class RoomDto {

    private int id;
    private String name;
    private String description;
    private String services;
    private String position;
    private String dimension;
    private int floorId;
    private String schemes;

    public RoomDto() {
    }

    public RoomDto(int id, String name, String description, String services, String position, String dimension, int floorId, String schemes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.services = services;
        this.position = position;
        this.dimension = dimension;
        this.floorId = floorId;
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

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getFloor() {
        return floorId;
    }

    public void setFloor(String floor) {
        this.floorId = floorId;
    }

    public String getSchemes() {
        return schemes;
    }

    public void setSchemes(String schemes) {
        this.schemes = schemes;
    }
}