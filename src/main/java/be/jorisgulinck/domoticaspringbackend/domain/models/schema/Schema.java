package be.jorisgulinck.domoticaspringbackend.domain.models.schema;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "schemes")
public class Schema {

    @Id
    @GeneratedValue
    @Column(name = "schema_id")
    private int id;

    @Column(name = "schema_start")
    private String start;

    @Column(name = "schema_end")
    private String end;

    @Column(name = "schema_device")
    private String device;

    @Column(name = "schema_device_value")
    private String deviceValue;

    @ManyToOne
    private Room room;

    public Schema(String start, String end, String device, String deviceValue, Room room) {
        this.start = start;
        this.end = end;
        this.device = device;
        this.deviceValue = deviceValue;
        this.room = room;
    }
}
