package be.jorisgulinck.domoticaspringbackend.domain.models.building;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Position {

    @Id
    @Column(name = "position_id")
    private int id;

    private int top;

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
