package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.apache.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController {

    //final static Logger logger = Logger.getLogger(FloorController.class);
    // TODO dto bijvoegen

    @Autowired
    FloorService floorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Floor> addFloor(@RequestBody Floor floor) {
        floorService.save(floor);
        //logger.debug("Added:: " + floor);
        return new ResponseEntity<Floor>(floor, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateFloor(@RequestBody Floor floor) {
        Floor existingFloor = floorService.getById(floor.getId());
        if (existingFloor == null) {
            //logger.debug("Employee with id " + floor.getId() + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            floorService.save(floor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Floor>> getAllFloors() {
        List<Floor> floors = floorService.getAll();
        if (floors.isEmpty()) {
            //logger.debug("Employees does not exists");
            return new ResponseEntity<List<Floor>>(HttpStatus.NO_CONTENT);
        }
        //logger.debug("Found " + floors.size() + " Employees");
        //logger.debug(floors);
        //logger.debug(Arrays.toString(floors.toArray()));
        return new ResponseEntity<List<Floor>>(floors, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Floor> getFloor(@PathVariable("id") int id) {
        Floor floor = floorService.getById(id);
        if (floor == null) {
            //logger.debug("Floor with id " + id + " does not exists");
            return new ResponseEntity<Floor>(HttpStatus.NOT_FOUND);
        }
        //logger.debug("Found Employee:: " + floor);
        return new ResponseEntity<Floor>(floor, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFloor(@PathVariable("id") int id) {
        Floor floor = floorService.getById(id);
        if (floor == null) {
            //logger.debug("Employee with id " + id + " does not exists");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            floorService.delete(id);
            //logger.debug("Employee with id " + id + " deleted");
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
}
