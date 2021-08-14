package be.jorisgulinck.domoticaspringbackend.dto.mappers;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.DeviceType;
import be.jorisgulinck.domoticaspringbackend.dto.RoomDto;
import be.jorisgulinck.domoticaspringbackend.services.FloorService;
import be.jorisgulinck.domoticaspringbackend.services.RoomService;
import be.jorisgulinck.domoticaspringbackend.services.SchemaService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RoomDtoMapper {

    private final FloorService floorService;
    private final SchemaService schemaService;
    private final RoomService roomService;

    public RoomDto roomToDto(Room room) {
        return new RoomDto(
                room.getId(),
                room.getName(),
                room.getDescription(),
                mapToTemperature(room.getAutomationDevices()),
                mapToLighting(room.getAutomationDevices()),
                mapToMusic(room.getAutomationDevices()),
                mapToCurtains(room.getAutomationDevices()),
                room.getPosition().getTop(),
                room.getPosition().getLeft(),
                room.getDimension().getHeight(),
                room.getDimension().getWidth(),
                room.getFloor().getId()
        );
    }

    // TODO change domain models so that id is automated -> see RoomDtoMapper
    public Room dtoToRoom(RoomDto roomDto) {
        return new Room(
                roomDto.getId(),
                roomDto.getName(),
                roomDto.getDescription(),
                mapToAutomationDeviceList(roomDto),
                new Dimension(80, roomDto.getWidth(), roomDto.getHeight()),
                new Position(80, roomDto.getTop(), roomDto.getLeft()),
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

    public String mapToTemperature(List<AutomationDevice> devices) {
        String deviceValue = null;
        for (AutomationDevice device : devices) {
            if (device.getDeviceType() == DeviceType.TEMPERATURE) {
                deviceValue = device.getValue();
            }
        }
        return deviceValue;
    }

    public String mapToLighting(List<AutomationDevice> devices) {
        String deviceValue = null;
        for (AutomationDevice device : devices) {
            if (device.getDeviceType() == DeviceType.LIGHTING) {
                deviceValue = device.getValue();
            }
        }
        return deviceValue;
    }

    public String mapToMusic(List<AutomationDevice> devices) {
        String deviceValue = null;
        for (AutomationDevice device : devices) {
            if (device.getDeviceType() == DeviceType.MUSIC) {
                deviceValue = device.getValue();
            }
        }
        return deviceValue;
    }

    public String mapToCurtains(List<AutomationDevice> devices) {
        String deviceValue = null;
        for (AutomationDevice device : devices) {
            if (device.getDeviceType() == DeviceType.CURTAINS) {
                deviceValue = device.getValue();
            }
        }
        return deviceValue;
    }

    // TODO afwerken van methoden in RoomDtoMapper
    private List<AutomationDevice> mapToAutomationDeviceList(RoomDto roomDto) {
        return null;
    }
}
