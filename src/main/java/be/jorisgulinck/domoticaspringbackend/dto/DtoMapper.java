package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapper {

    // TODO implementing ModelMapper and finishing the methods of this class.

    public FloorDto floorToDto(Floor floor) {
        return null;
    }

    public Floor floorDtoToFloor(FloorDto floorDto) {
        return null;
    }

    public List<FloorDto> floorsToDtoList(List<Floor> floors) {
        return null;
    }

    public RoomDto roomToDto(Room room) {
        return null;
    }

    public Room roomDtoToRoom(RoomDto roomDto) {
        return null;
    }

    public SchemaDto schemaToDto(Schema schema) {
        return null;
    }

    public Schema schemaDtoToSchema(SchemaDto schemaDto) {
        return null;
    }

}
