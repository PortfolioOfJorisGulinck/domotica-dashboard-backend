package be.jorisgulinck.domoticaspringbackend.domain.models.building;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @Column(name = "position_id")
    private int id;

    @Column(name = "top")
    private int top;

    @Column(name = "lef")
    private int left;

    @OneToOne
    private Room room;

    public Position() {
    }

    public Position(int id, int top, int left, Room room) {
        this.id = id;
        this.top = top;
        this.left = left;
        this.room = room;
    }
}
