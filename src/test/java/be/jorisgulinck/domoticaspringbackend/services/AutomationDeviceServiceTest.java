package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.DeviceType;
import be.jorisgulinck.domoticaspringbackend.repository.AutomationDeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutomationDeviceServiceTest {

    @Mock
    private AutomationDeviceRepository automationDeviceRepository;

    @InjectMocks
    private AutomationDeviceService automationDeviceService;

    private AutomationDevice automationDevice;
    private List<AutomationDevice> automationDevices;

    @BeforeEach
    void setUp() {
        automationDevice = new AutomationDevice(20, DeviceType.CURTAINS, "closed", new Room());
        automationDevices = new ArrayList<>(Arrays.asList(automationDevice));
    }

    @Test
    void save() {
        when(automationDeviceRepository.save(any())).then(returnsFirstArg());
        AutomationDevice savedDevice = automationDeviceService.save(automationDevice);

        assertEquals(savedDevice.getDeviceType(), automationDevice.getDeviceType());
    }

    @Test
    void getById() {
        when(automationDeviceRepository.findById(20)).thenReturn(Optional.of(automationDevice));
        AutomationDevice foundDevice = automationDeviceService.getById(20);

        assertEquals(foundDevice.getDeviceType(), automationDevice.getDeviceType());
    }

    @Test
    void getAll() {
        when(automationDeviceRepository.findAll()).thenReturn(automationDevices);
        List<AutomationDevice> foundDevices = automationDeviceService.getAll();

        assertEquals(foundDevices.get(0).getDeviceType(), automationDevices.get(0).getDeviceType());
    }

    @Test
    void delete() {

    }
}