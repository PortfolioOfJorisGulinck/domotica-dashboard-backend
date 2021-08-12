package be.jorisgulinck.domoticaspringbackend.domain.models.building;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @Column(name = "position_id")
    private int id;

    @Column(name = "top_position")
    private int top;

    @Column(name = "left_position")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
