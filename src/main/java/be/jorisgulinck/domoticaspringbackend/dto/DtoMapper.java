package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapper {

    /*
    @Autowired
    RoomService roomService;

    public FloorDto floorToDto(Floor floor) {
        List<Integer> roomIdList = null;
        for (Room room : floor.getRooms()) {
            roomIdList.add(room.getId());
        }
        return new FloorDto(
                floor.getId(),
                floor.getName(),
                floor.getImage(),
                roomIdList);
    }

    public Floor floorDtoToFloor(FloorDto floorDto) {
        List<Room> rooms = null;
        for (int roomId : floorDto.getRoomIdList()) {
            rooms.add(roomService.getById(roomId));
        }
        return new Floor(
                floorDto.getId(),
                floorDto.getName(),
                floorDto.getImage(),
                rooms);
    }

    public List<FloorDto> floorsToDtoList(List<Floor> floors) {
        List<FloorDto> floorDtoList = null;
        for (Floor floor : floors) {
            floorDtoList.add(floorToDto(floor));
        }
        return floorDtoList;
    }

    public RoomDto roomToDto(Room room) {
        return new RoomDto(
                room.getId(),
                room.getName(),
                room.getDescription(),
                room.getServices().toString(),
                room.getPosition().toString(),
                room.getDimension().toString(),
                room.getFloor().getId(),
                room.getSchemes().toString());
    }


    public Room roomDtoToRoom(RoomDto roomDto) {
        return new Room(
                roomDto.getId(),
                roomDto.getName(),
                roomDto.getDescription(),
                roomDto.getServices(),
                roomDto.getDimension(),
                roomDto.getPosition(),
                roomDto.getFloor(),
                roomDto.getSchemes());
    }


    public SchemaDto schemaToDto(Schema schema) {
        return new SchemaDto(
                schema.getId(),
                schema.getService(),
                schema.getAmount(),
                schema.getStart(),
                schema.getEnd(),
                schema.getRoom());
    }

    public Schema schemaDtoToSchema(SchemaDto schemaDto) {
        return new Schema(
                schemaDto.getId(),
                schemaDto.getService(),
                schemaDto.getAmount(),
                schemaDto.getStart(),
                schemaDto.getEnd(),
                schemaDto.getRoom());
    }
    */
}