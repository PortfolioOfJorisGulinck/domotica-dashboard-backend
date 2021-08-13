package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.dto.AutomationDeviceDto;
import be.jorisgulinck.domoticaspringbackend.dto.DtoMapper;
import be.jorisgulinck.domoticaspringbackend.services.AutomationDeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/automationdevices")
public class AutomationDeviceController {

    final static Logger logger = Logger.getLogger(FloorController.class);

    private final AutomationDeviceService automationDeviceService;
    private final DtoMapper dtoMapper;

    @Autowired
    public AutomationDeviceController(AutomationDeviceService automationDeviceService, DtoMapper dtoMapper) {
        this.automationDeviceService = automationDeviceService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping
    public ResponseEntity<AutomationDeviceDto> addAutomationDevice(@RequestBody AutomationDeviceDto automationDeviceDto) {
        automationDeviceService.save(dtoMapper.dtoToAutomationDevice(automationDeviceDto));
        logger.debug("Added:: " + automationDeviceDto);
        return new ResponseEntity<>(automationDeviceDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateAutomationDevice(@RequestBody AutomationDeviceDto automationDeviceDto) {
        AutomationDevice existingAutomationDevice = automationDeviceService.getById(automationDeviceDto.getId());
        if (existingAutomationDevice == null) {
            logger.debug("AutomationDevice with id " + automationDeviceDto.getId() + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            automationDeviceService.save(dtoMapper.dtoToAutomationDevice(automationDeviceDto));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<AutomationDeviceDto>> getAllAutomationDevices() {
        List<AutomationDevice> automationDevices = automationDeviceService.getAll();
        if (automationDevices.isEmpty()) {
            logger.debug("There ar no automation devices");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + automationDevices.size() + " automation devices");
        logger.debug(automationDevices);
        logger.debug(Arrays.toString(automationDevices.toArray()));
        return new ResponseEntity<>(dtoMapper.automationDevicesToDtoList(automationDevices), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AutomationDeviceDto> getAutomationDevice(@PathVariable int id) {
        AutomationDevice automationDevice = automationDeviceService.getById(id);
        if (automationDevice == null) {
            logger.debug("Automation device with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found automation device:: " + automationDevice);
        return new ResponseEntity<>(dtoMapper.automationDeviceToDto(automationDevice), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAutomationDevice(@PathVariable int id) {
        AutomationDevice automationDevice = automationDeviceService.getById(id);
        if (automationDevice == null) {
            logger.debug("Automation device with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            automationDeviceService.delete(id);
            logger.debug("Automation device with id " + id + " deleted");
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }
}
