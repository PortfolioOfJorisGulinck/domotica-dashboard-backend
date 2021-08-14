package be.jorisgulinck.domoticaspringbackend.domain.models.device;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "automation_devices")
public class AutomationDevice {
    @Id
    @Column(name = "automation_device_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "automation_device_type")
    private DeviceType deviceType;

    @Column(name = "automation_device_value")
    private String value;

    @ManyToOne
    private Room room;
}
