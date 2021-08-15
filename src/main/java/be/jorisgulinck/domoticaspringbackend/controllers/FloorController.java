package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.dto.FloorDto;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.dto.mappers.FloorDtoMapper;
import be.jorisgulinck.domoticaspringbackend.services.FloorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/floors")
public class FloorController {

    final static Logger logger = Logger.getLogger(FloorController.class);

    private final FloorService floorService;
    private final FloorDtoMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<FloorDto>> getAllFloors() {
        List<Floor> floors = floorService.getAll();
        if (floors.isEmpty()) {
            logger.debug("There ar no floors");
            System.out.println("there are no floors");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + floors.size() + " floors");
        System.out.println(floors);
        logger.debug(floors);
        logger.debug(Arrays.toString(floors.toArray()));
        return new ResponseEntity<>(dtoMapper.floorsToDtoList(floors), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<FloorDto> getFloor(@PathVariable int id) {
        Floor floor = floorService.getById(id);
        if (floor == null) {
            logger.debug("Floor with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found floor:: " + floor);
        return new ResponseEntity<>(dtoMapper.floorToDto(floor), HttpStatus.OK);
    }
}
