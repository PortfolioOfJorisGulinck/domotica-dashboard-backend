package be.jorisgulinck.domoticaspringbackend.models.building;

import javax.persistence.*;
import java.util.List;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "floor",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Room> rooms;

    public Floor() {
    }

    public Floor(int id, String name, String image, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
