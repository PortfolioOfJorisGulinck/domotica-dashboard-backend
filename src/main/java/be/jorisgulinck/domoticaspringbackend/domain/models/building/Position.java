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
@Table(name = "positions")
public class Position {

    @Id
    @Column(name = "position_id")
    private int id;

    @Column(name = "top_position")
    private int top;

    @Column(name = "left_position")
    private int left;
}
