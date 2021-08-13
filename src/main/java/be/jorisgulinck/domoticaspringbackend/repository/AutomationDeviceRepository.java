package be.jorisgulinck.domoticaspringbackend.repository;

import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationDeviceRepository extends JpaRepository<AutomationDevice, Integer> {
}
