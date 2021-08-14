package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDto {

    private int id;
    private String name;
    private String description;
    private List<Integer> automationServiceIdList;
    private Position position;
    private Dimension dimension;
    private int floorId;

}