package be.jorisgulinck.domoticaspringbackend.dto.mappers;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.dto.RoomDto;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import be.jorisgulinck.domoticaspringbackend.services.SchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomDtoMapper {

    private final SchemaService schemaService;
    private final RoomService roomService;

    public RoomDto roomToDto(Room room) {
        return new RoomDto(
                room.getId(),
                room.getName(),
                room.getDescription(),
                room.getTemperature(),
                room.getLighting(),
                room.getMusic(),
                room.getCurtains(),
                room.getPosition().getTop(),
                room.getPosition().getLeft(),
                room.getDimension().getHeight(),
                room.getDimension().getWidth(),
                room.getFloor().getId()
        );
    }

    public Room dtoToRoom(RoomDto roomDto, Room room) {
        room.setTemperature(roomDto.getTemperature());
        room.setLighting(roomDto.getLighting());
        room.setMusic(roomDto.getMusic());
        room.setCurtains(roomDto.getCurtains());
        room.setSchemes(schemaService.getByRoom(roomService.getById(roomDto.getId())));
        return room;
    }

    public List<RoomDto> roomsToDtoList(List<Room> rooms) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (Room room : rooms) {
            roomDtoList.add(roomToDto(room));
        }
        return roomDtoList;
    }

}
