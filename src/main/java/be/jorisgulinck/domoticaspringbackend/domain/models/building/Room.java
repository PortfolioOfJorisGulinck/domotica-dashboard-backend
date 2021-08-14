package be.jorisgulinck.domoticaspringbackend.domain.models.building;

import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "room_id")
    private int id;

    @Column(name = "room_name")
    private String name;

    @Column(name = "room_description")
    private String description;

    @OneToMany(mappedBy = "room")
    private List<AutomationDevice> automationDevices;

    @OneToOne
    private Dimension dimension;

    @OneToOne
    private Position position;

    @ManyToOne
    private Floor floor;

    @OneToMany(mappedBy = "room")
    private List<Schema> schemes;

    public Room(int id) {
        this.id = id;
    }
}

