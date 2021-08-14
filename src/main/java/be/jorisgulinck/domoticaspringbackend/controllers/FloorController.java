package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.dto.DtoMapper;
import be.jorisgulinck.domoticaspringbackend.dto.FloorDto;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
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
@RequestMapping("/floors")
public class FloorController {

    final static Logger logger = Logger.getLogger(FloorController.class);

    private final FloorService floorService;
    private final DtoMapper dtoMapper;

    @PostMapping
    public ResponseEntity<FloorDto> addFloor(@RequestBody FloorDto floorDto) {
        floorService.save(dtoMapper.dtoToFloor(floorDto));
        logger.debug("Added:: " + floorDto);
        return new ResponseEntity<>(floorDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateFloor(@RequestBody FloorDto floorDto) {
        Floor existingFloor = floorService.getById(floorDto.getId());
        if (existingFloor == null) {
            logger.debug("Floor with id " + floorDto.getId() + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            floorService.save(dtoMapper.dtoToFloor(floorDto));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<FloorDto>> getAllFloors() {
        List<Floor> floors = floorService.getAll();
        if (floors.isEmpty()) {
            logger.debug("There ar no floors");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + floors.size() + " floors");
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFloor(@PathVariable int id) {
        Floor floor = floorService.getById(id);
        if (floor == null) {
            logger.debug("Floor with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            floorService.delete(id);
            logger.debug("Floor with id " + id + " deleted");
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }
}
