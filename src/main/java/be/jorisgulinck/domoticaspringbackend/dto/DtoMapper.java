package be.jorisgulinck.domoticaspringbackend.dto;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.services.AutomationDeviceService;
import be.jorisgulinck.domoticaspringbackend.services.FloorService;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import be.jorisgulinck.domoticaspringbackend.services.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoMapper {

    private final RoomService roomService;
    private final FloorService floorService;
    private final SchemaService schemaService;
    private final AutomationDeviceService automationDeviceService;

    @Autowired
    public DtoMapper(RoomService roomService, FloorService floorService, SchemaService schemaService, AutomationDeviceService automationDeviceService) {
        this.floorService = floorService;
        this.schemaService = schemaService;
        this.roomService = roomService;
        this.automationDeviceService = automationDeviceService;
    }

    public FloorDto floorToDto(Floor floor) {
        List<Integer> roomIdList = new ArrayList<>();
        for (Room room : floor.getRooms()) {
            roomIdList.add(room.getId());
        }
        return new FloorDto(
                floor.getId(),
                floor.getName(),
                floor.getImage(),
                roomIdList
        );
    }

    public Floor dtoToFloor(FloorDto floorDto) {
        List<Room> rooms = new ArrayList<>();
        for (int roomId : floorDto.getRoomIdList()) {
            rooms.add(roomService.getById(roomId));
        }
        return new Floor(
                floorDto.getId(),
                floorDto.getName(),
                floorDto.getImage(),
                rooms
        );
    }

    public List<FloorDto> floorsToDtoList(List<Floor> floors) {
        List<FloorDto> floorDtoList = new ArrayList<>();
        for (Floor floor : floors) {
            floorDtoList.add(floorToDto(floor));
        }
        return floorDtoList;
    }

    public RoomDto roomToDto(Room room) {
        List<Integer> automationServiceIdList = new ArrayList<>();
        for (AutomationDevice automationDevice : room.getAutomationServices()) {
            automationServiceIdList.add(automationDevice.getId());
        }
        return new RoomDto(
                room.getId(),
                room.getName(),
                room.getDescription(),
                automationServiceIdList,
                room.getPosition(),
                room.getDimension(),
                room.getFloor().getId()
        );
    }

    public Room dtoToRoom(RoomDto roomDto) {
        List<AutomationDevice> automationDevices = new ArrayList<>();
        for (int automationServiceId : roomDto.getAutomationServiceIdList()) {
            automationDevices.add(automationDeviceService.getById(automationServiceId));
        }
        return new Room(
                roomDto.getId(),
                roomDto.getName(),
                roomDto.getDescription(),
                automationDevices,
                roomDto.getDimension(),
                roomDto.getPosition(),
                floorService.getById(roomDto.getFloorId()),
                schemaService.getByRoom(roomService.getById(roomDto.getId()))
        );
    }

    public List<RoomDto> roomsToDtoList(List<Room> rooms) {
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (Room room : rooms) {
            roomDtoList.add(roomToDto(room));
        }
        return roomDtoList;
    }


    public SchemaDto schemaToDto(Schema schema) {
        return new SchemaDto(
                schema.getId(),
                schema.getStart(),
                schema.getEnd(),
                schema.getAutomationDevice(),
                schema.getRoom().getId()
        );
    }

    public Schema dtoToSchema(SchemaDto schemaDto) {
        return new Schema(
                schemaDto.getId(),
                schemaDto.getStart(),
                schemaDto.getEnd(),
                schemaDto.getAutomationDevice(),
                roomService.getById(schemaDto.getRoomId())
        );
    }

    public List<SchemaDto> schemasToDtoList(List<Schema> schemas) {
        List<SchemaDto> schemaDtoList = new ArrayList<>();
        for (Schema schema : schemas) {
            schemaDtoList.add(schemaToDto(schema));
        }
        return schemaDtoList;
    }

    public AutomationDeviceDto automationDeviceToDto(AutomationDevice automationDevice) {
        return new AutomationDeviceDto(
                automationDevice.getId(),
                automationDevice.getServiceType(),
                automationDevice.getValue(),
                automationDevice.getRoom().getId()
        );
    }

    public AutomationDevice dtoToAutomationDevice(AutomationDeviceDto automationDeviceDto) {
        return new AutomationDevice(
                automationDeviceDto.getId(),
                automationDeviceDto.getServiceType(),
                automationDeviceDto.getValue(),
                roomService.getById(automationDeviceDto.getRoomId())
        );
    }

    public List<AutomationDeviceDto> automationDevicesToDtoList(List<AutomationDevice> automationDevices) {
        List<AutomationDeviceDto> automationDeviceDtoList = new ArrayList<>();
        for (AutomationDevice automationDevice : automationDevices) {
            automationDeviceDtoList.add(automationDeviceToDto(automationDevice));
        }
        return automationDeviceDtoList;
    }
}
