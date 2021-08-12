package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DtoMapperTest {

    Floor floor;
    FloorDto floorDto;
    List<Room> rooms;
    List<Integer> listOfRoomIds;

    @InjectMocks
    DtoMapper dtoMapper;

    @Mock
    RoomService roomService;

    @BeforeEach
    public void init(){

        rooms = new ArrayList<>(Arrays.asList(new Room(1), new Room(2)));

        floor = new Floor(1, "basement", "image", rooms);

        listOfRoomIds = rooms
                .stream()
                .map(Room::getId)
                .collect(Collectors.toList());

        floorDto = new FloorDto(1, "basement", "image", listOfRoomIds);
    }

    @Test
    void testFloorToDto() {
        FloorDto floorDtoToTest = dtoMapper.floorToDto(floor);

        assertEquals(floor.getId(), floorDtoToTest.getId());
        assertEquals(floor.getName(), floorDtoToTest.getName());
        assertEquals(listOfRoomIds, floorDtoToTest.getRoomIdList());
    }

    @Test
    void testDtoToFloor() {
        Floor floorToTest = dtoMapper.dtoToFloor(floorDto);

        //when(roomService.getById(anyInt())).then(firstArg);

        assertEquals(floorToTest.getId(), floorDto.getId());
        assertEquals(floorToTest.getName(), floorDto.getName());
        //assertEquals(floorToTest.getRooms().indexOf(0), rooms.indexOf(0));
    }
}