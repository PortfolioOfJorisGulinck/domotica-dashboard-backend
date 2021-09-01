package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.dto.RoomDto;
import be.jorisgulinck.domoticaspringbackend.dto.mappers.RoomDtoMapper;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/rooms")
public class RoomController {

    final static Logger logger = Logger.getLogger(RoomController.class);

    private final RoomDtoMapper dtoMapper;
    private final RoomService roomService;

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> updateRoom(@PathVariable int id, @RequestBody RoomDto roomDto) {
        Room existingRoom = roomService.getById(id);
        if (existingRoom == null) {
            logger.debug("Room with id " + roomDto.getId() + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            roomService.save(dtoMapper.dtoToRoom(roomDto, existingRoom));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        List<Room> rooms = roomService.getAll();
        if (rooms.isEmpty()) {
            logger.debug("There ar no rooms");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + rooms.size() + " rooms");
        logger.debug(rooms);
        logger.debug(Arrays.toString(rooms.toArray()));
        return new ResponseEntity<>(dtoMapper.roomsToDtoList(rooms), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable int id) {
        Room room = roomService.getById(id);
        if (room == null) {
            logger.debug("Room with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found room:: " + room);
        return new ResponseEntity<>(dtoMapper.roomToDto(room), HttpStatus.OK);
    }
}
