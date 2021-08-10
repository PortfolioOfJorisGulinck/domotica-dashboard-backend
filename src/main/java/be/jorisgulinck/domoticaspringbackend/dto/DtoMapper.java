package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoMapper {

    private final ModelMapper mapper;
    private final RoomService roomService;

    @Autowired
    public DtoMapper(RoomService roomService) {
        this.mapper = new ModelMapper();
        this.roomService = roomService;
    }

    // TODO implementing ModelMapper and finishing the methods of this class.

    public FloorDto floorToDto(Floor floor) {
        FloorDto floorDto = new FloorDto();
        floorDto.setId(floor.getId());
        floorDto.setName(floor.getName());
        floorDto.setImage(floor.getImage());
        List<Integer> roomIdList = new ArrayList<>();
        for (Room room : floor.getRooms()) {
            roomIdList.add(room.getId());
        }
        floorDto.setRoomIdList(roomIdList);
        return floorDto;
    }

    public Floor DtoToFloor(FloorDto floorDto) {
        Floor floor = new Floor();
        floor.setId(floorDto.getId());
        floor.setName(floorDto.getName());
        floor.setImage(floorDto.getImage());
        List<Room> rooms = new ArrayList<>();
        for (int roomId : floorDto.getRoomIdList()) {
            rooms.add(roomService.getById(roomId));
        }
        floor.setRooms(rooms);
        return floor;
    }

    public List<FloorDto> floorsToDtoList(List<Floor> floors) {
        List<FloorDto> floorDtoList = new ArrayList<>();
        for (Floor floor : floors) {
            floorDtoList.add(floorToDto(floor));
        }
        return floorDtoList;
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
