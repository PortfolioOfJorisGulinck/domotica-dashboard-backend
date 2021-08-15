package be.jorisgulinck.domoticaspringbackend.dto.mappers;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.dto.FloorDto;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FloorDtoMapper {

    //private final RoomService roomService;

    public FloorDto floorToDto(Floor floor) {
        List<Integer> roomIdList = new ArrayList<>();
        for (Room room : floor.getRooms()) {
            roomIdList.add(room.getId());
        }
        return new FloorDto(
                floor.getId(),
                floor.getName(),
                floor.getImage(),
                roomIdList
        );
    }

    /*public Floor dtoToFloor(FloorDto floorDto) {
        List<Room> rooms = new ArrayList<>();
        for (int roomId : floorDto.getRooms()) {
            rooms.add(roomService.getById(roomId));
        }
        return new Floor(
                floorDto.getId(),
                floorDto.getName(),
                floorDto.getImage(),
                rooms
        );
    }*/

    public List<FloorDto> floorsToDtoList(List<Floor> floors) {
        List<FloorDto> floorDtoList = new ArrayList<>();
        for (Floor floor : floors) {
            floorDtoList.add(floorToDto(floor));
        }
        return floorDtoList;
    }

}
