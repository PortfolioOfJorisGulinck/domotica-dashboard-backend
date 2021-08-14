package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.repository.FloorRepository;
import be.jorisgulinck.domoticaspringbackend.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    private Room room;
    private List<Room> rooms;

    @BeforeEach
    void setUp() {
        List<AutomationDevice> automationDevices = new ArrayList<>(Arrays.asList(new AutomationDevice(), new AutomationDevice()));
        List<Schema> schemes = new ArrayList<>(Arrays.asList(new Schema(), new Schema()));
        room = new Room(20,
                "new room",
                "description of new room",
                automationDevices,
                new Dimension(20, 50, 50),
                new Position(20, 50, 50),
                new Floor(),
                schemes
        );
        rooms = new ArrayList<>(Arrays.asList(room));
    }

    @Test
    void save() {
        when(roomRepository.save(any())).then(returnsFirstArg());
        Room savedRoom = roomService.save(room);

        assertEquals(savedRoom.getName(), room.getName());
    }

    @Test
    void getById() {
        when(roomRepository.findById(20)).thenReturn(Optional.of(room));
        Room foundRoom = roomService.getById(20);

        assertEquals(foundRoom.getName(), room.getName());
    }

    @Test
    void getAll() {
        when(roomRepository.findAll()).thenReturn(rooms);
        List<Room> foundRooms = roomService.getAll();

        assertEquals(foundRooms.get(0).getName(), rooms.get(0).getName());
    }

    @Test
    void delete() {

    }
}