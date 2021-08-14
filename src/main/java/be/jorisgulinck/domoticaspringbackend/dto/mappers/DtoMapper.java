package be.jorisgulinck.domoticaspringbackend.dto.mappers;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.dto.FloorDto;
import be.jorisgulinck.domoticaspringbackend.dto.RoomDto;
import be.jorisgulinck.domoticaspringbackend.dto.SchemaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DtoMapper {

    private final FloorDtoMapper floorDtoMapper;
    private final RoomDtoMapper roomDtoMapper;
    private final SchemaDtoMapper schemaDtoMapper;

    public FloorDto floorToDto(Floor floor) {
        return floorDtoMapper.floorToDto(floor);
    }

    public Floor dtoToFloor(FloorDto floorDto) {
        return floorDtoMapper.dtoToFloor(floorDto);
    }

    public List<FloorDto> floorsToDtoList(List<Floor> floors) {
        return floorDtoMapper.floorsToDtoList(floors);
    }

    public RoomDto roomToDto(Room room) {
        return roomDtoMapper.roomToDto(room);
    }

    public Room dtoToRoom(RoomDto roomDto) {
        return roomDtoMapper.dtoToRoom(roomDto);
    }

    public List<RoomDto> roomsToDtoList(List<Room> rooms) {
        return roomDtoMapper.roomsToDtoList(rooms);
    }

    public SchemaDto schemaToDto(Schema schema) {
        return schemaDtoMapper.schemaToDto(schema);
    }

    public Schema dtoToSchema(SchemaDto schemaDto) {
        return schemaDtoMapper.dtoToSchema(schemaDto);
    }

    public List<SchemaDto> schemasToDtoList(List<Schema> schemas) {
        return schemaDtoMapper.schemasToDtoList(schemas);
    }
}
