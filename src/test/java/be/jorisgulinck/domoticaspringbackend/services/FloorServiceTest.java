package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.repository.FloorRepository;
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
class FloorServiceTest {

    @Mock
    private FloorRepository floorRepository;

    @InjectMocks
    private FloorService floorService;

    private Floor floor;
    private List<Floor> floors;

    @BeforeEach
    void setUp() {
        List<Room> rooms = new ArrayList<>(Arrays.asList(new Room(1), new Room(2)));
        floor = new Floor(20, "new floor", "/images/new-floor.jpg", rooms);
        floors = new ArrayList<>(Arrays.asList(floor));
    }

    @Test
    void save() {
        when(floorRepository.save(any())).then(returnsFirstArg());
        Floor savedFloor = floorService.save(floor);

        assertEquals(savedFloor.getName(), floor.getName());
    }

    @Test
    void getById() {
        when(floorRepository.findById(20)).thenReturn(Optional.of(floor));
        Floor foundFloor = floorService.getById(20);

        assertEquals(foundFloor.getName(), floor.getName());
    }

    @Test
    void getAll() {
        when(floorRepository.findAll()).thenReturn(floors);
        List<Floor> foundFloors = floorService.getAll();

        assertEquals(foundFloors.get(0).getName(), floors.get(0).getName());
    }

    @Test
    void delete() {

    }

}