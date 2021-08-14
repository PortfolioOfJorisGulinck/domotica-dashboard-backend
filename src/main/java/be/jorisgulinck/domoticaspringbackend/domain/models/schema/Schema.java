package be.jorisgulinck.domoticaspringbackend.domain.models.schema;

import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
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
@Table(name = "schemes")
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schema_id")
    private int id;

    @Column(name = "schema_start")
    private String start;

    @Column(name = "schema_end")
    private String end;

    @OneToOne
    private AutomationDevice automationDevice;

    @ManyToOne
    private Room room;
}
