package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.dto.SchemaDto;
import be.jorisgulinck.domoticaspringbackend.dto.mappers.SchemaDtoMapper;
import be.jorisgulinck.domoticaspringbackend.services.SchemaService;
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
@RequestMapping("/schemes")
public class SchemaController {

    final static Logger logger = Logger.getLogger(FloorController.class);

    private final SchemaService schemaService;
    private final SchemaDtoMapper dtoMapper;

    @PostMapping
    public ResponseEntity<SchemaDto> addSchema(@RequestBody SchemaDto schemaDto) {
        schemaService.save(dtoMapper.dtoToSchema(schemaDto));
        logger.debug("Added:: " + schemaDto);
        return new ResponseEntity<>(schemaDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateSchema(@RequestBody SchemaDto schemaDto) {
        Schema existingSchema = schemaService.getById(schemaDto.getId());
        if (existingSchema == null) {
            logger.debug("Schema with id " + schemaDto.getId() + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            schemaService.save(dtoMapper.dtoToSchema(schemaDto));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<SchemaDto>> getAllSchemas() {
        List<Schema> schemas = schemaService.getAll();
        if (schemas.isEmpty()) {
            logger.debug("There ar no schemas");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + schemas.size() + " schemas");
        logger.debug(schemas);
        logger.debug(Arrays.toString(schemas.toArray()));
        return new ResponseEntity<>(dtoMapper.schemasToDtoList(schemas), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<SchemaDto> getSchema(@PathVariable int id) {
        Schema schema = schemaService.getById(id);
        if (schema == null) {
            logger.debug("Schema with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.debug("Found schema:: " + schema);
        return new ResponseEntity<>(dtoMapper.schemaToDto(schema), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSchema(@PathVariable int id) {
        Schema schema = schemaService.getById(id);
        if (schema == null) {
            logger.debug("Schema with id " + id + " does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            schemaService.delete(id);
            logger.debug("Schema with id " + id + " deleted");
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }
}
