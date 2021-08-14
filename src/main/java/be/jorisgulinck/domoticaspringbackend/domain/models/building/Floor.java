package be.jorisgulinck.domoticaspringbackend.domain.models.building;

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
@Table(name = "floors")
public class Floor {
    @Id
    @Column(name = "floor_id")
    private int id;

    @Column(name = "floor_name")
    private String name;

    @Column(name = "floor_image")
    private String image;

    @OneToMany(mappedBy = "floor")
    private List<Room> rooms;
}
