package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;

import java.util.List;

public class RoomDto {

    private int id;
    private String name;
    private String description;
    private List<Integer> automationServiceIdList;
    private Position position;
    private Dimension dimension;
    private int floorId;

    public RoomDto() {
    }

    public RoomDto(int id, String name, String description, List<Integer> automationServiceIdList, Position position, Dimension dimension, int floorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.automationServiceIdList = automationServiceIdList;
        this.position = position;
        this.dimension = dimension;
        this.floorId = floorId;
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


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public List<Integer> getAutomationServiceIdList() {
        return automationServiceIdList;
    }

    public void setAutomationServiceIdList(List<Integer> automationServiceIdList) {
        this.automationServiceIdList = automationServiceIdList;
    }
}