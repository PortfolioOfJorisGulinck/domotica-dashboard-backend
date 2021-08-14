package be.jorisgulinck.domoticaspringbackend.domain.models.building;

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
@Table(name = "dimensions")
public class Dimension {
    @Id
    @Column(name = "dimension_id")
    private int id;

    @Column(name = "dimension_width")
    private int width;

    @Column(name = "dimension_height")
    private int height;
}
