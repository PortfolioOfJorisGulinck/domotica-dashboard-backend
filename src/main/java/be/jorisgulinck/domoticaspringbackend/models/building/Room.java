package be.jorisgulinck.domoticaspringbackend.models.building;

import be.jorisgulinck.domoticaspringbackend.models.schema.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
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

    @Column(name = "room_temperature")
    private String temperature;

    @Column(name = "room_lighting")
    private String lighting;

    @Column(name = "room_music")
    private String music;

    @Column(name = "room_curtains")
    private String curtains;

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

    public Room(int id, String name, String description, String temperature, String lighting, String music,
                String curtains, Dimension dimension, Position position, Floor floor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.temperature = temperature;
        this.lighting = lighting;
        this.music = music;
        this.curtains = curtains;
        this.dimension = dimension;
        this.position = position;
        this.floor = floor;
    }
}

