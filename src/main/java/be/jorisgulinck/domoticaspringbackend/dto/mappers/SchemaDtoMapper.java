package be.jorisgulinck.domoticaspringbackend.dto.mappers;

import be.jorisgulinck.domoticaspringbackend.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.dto.SchemaDto;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import be.jorisgulinck.domoticaspringbackend.services.SchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SchemaDtoMapper {

    private final RoomService roomService;
    private final SchemaService schemaService;

    public SchemaDto schemaToDto(Schema schema) {
        return new SchemaDto(
                schema.getId(),
                schema.getRoom().getId(),
                schema.getDevice(),
                schema.getDeviceValue(),
                schema.getStart(),
                schema.getEnd()
        );
    }

    public Schema dtoToSchema(SchemaDto schemaDto) {
        Room room = roomService.getById(schemaDto.getRoomId());
        Schema schema = schemaService.getById(schemaDto.getId());
        if (schema == null) {
            return new Schema(
                    schemaDto.getStart(),
                    schemaDto.getEnd(),
                    schemaDto.getService(),
                    schemaDto.getAmount(),
                    room
            );
        } else {
            schema.setStart(schemaDto.getStart());
            schema.setEnd(schemaDto.getEnd());
            schema.setDevice(schemaDto.getService());
            schema.setDeviceValue(schemaDto.getAmount());
            return schema;
        }
    }

    public List<SchemaDto> schemasToDtoList(List<Schema> schemas) {
        List<SchemaDto> schemaDtoList = new ArrayList<>();
        for (Schema schema : schemas) {
            schemaDtoList.add(schemaToDto(schema));
        }
        return schemaDtoList;
    }

}
