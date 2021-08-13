package be.jorisgulinck.domoticaspringbackend.services;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.repository.AutomationDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AutomationDeviceService implements CrudService<AutomationDevice>{

    private final AutomationDeviceRepository automationDeviceRepository;

    @Autowired
    public AutomationDeviceService(AutomationDeviceRepository automationDeviceRepository) {
        this.automationDeviceRepository = automationDeviceRepository;
    }

    @Override
    public AutomationDevice save(AutomationDevice automationDevice) {
        return automationDeviceRepository.save(automationDevice);
    }

    @Override
    public AutomationDevice getById(int id) {
        return automationDeviceRepository.getById(id);
    }

    @Override
    public List<AutomationDevice> getAll() {
        return automationDeviceRepository.findAll();
    }

    @Override
    public void delete(int id) {
        AutomationDevice automationDevice = automationDeviceRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        automationDeviceRepository.delete(automationDevice);

    }
}
