package be.jorisgulinck.domoticaspringbackend.dto.mappers;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.DeviceType;
import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.dto.SchemaDto;
import be.jorisgulinck.domoticaspringbackend.services.AutomationDeviceService;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SchemaDtoMapper {

    private final RoomService roomService;

    public SchemaDto schemaToDto(Schema schema) {
        return new SchemaDto(
                schema.getId(),
                schema.getRoom().getId(),
                schema.getAutomationDevice().getDeviceType().toString(),
                schema.getAutomationDevice().getValue(),
                schema.getStart(),
                schema.getEnd()
        );
    }

    // TODO change domain models so that id is automated or how existing id is saved -> see dto
    public Schema dtoToSchema(SchemaDto schemaDto) {
        Room room = roomService.getById(schemaDto.getRoomId());
        return new Schema(
                schemaDto.getId(),
                schemaDto.getStart(),
                schemaDto.getEnd(),
                new AutomationDevice(80, mapToDeviceType(schemaDto.getService()), schemaDto.getAmount(), room),
                room
        );
    }

    public List<SchemaDto> schemasToDtoList(List<Schema> schemas) {
        List<SchemaDto> schemaDtoList = new ArrayList<>();
        for (Schema schema : schemas) {
            schemaDtoList.add(schemaToDto(schema));
        }
        return schemaDtoList;
    }

    private DeviceType mapToDeviceType(String service) {
        switch (service) {
            case "temperature":
                return DeviceType.TEMPERATURE;
            case "lighting":
                return DeviceType.LIGHTING;
            case "music":
                return DeviceType.MUSIC;
            case "curtains":
                return DeviceType.CURTAINS;
            default:
                return null;
        }
    }
}
