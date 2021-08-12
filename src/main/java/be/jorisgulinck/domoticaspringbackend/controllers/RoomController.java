package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.dto.DtoMapper;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    final static Logger logger = Logger.getLogger(RoomController.class);

    private final DtoMapper dtoMapper;
    private final RoomService roomService;

    @Autowired
    public RoomController(DtoMapper dtoMapper, RoomService roomService) {
        this.dtoMapper = dtoMapper;
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAll();
        if (rooms.isEmpty()) {
            //logger.debug("There ar no floors");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //logger.debug("Found " + floors.size() + " floors");
        //logger.debug(floors);
        //logger.debug(Arrays.toString(floors.toArray()));
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

}
