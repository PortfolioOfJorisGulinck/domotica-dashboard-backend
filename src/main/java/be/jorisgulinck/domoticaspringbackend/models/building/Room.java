package be.jorisgulinck.domoticaspringbackend.models.building;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String lighting;
    private String music;
    private int top;
    private int left;
    private int width;
    private int height;

    @ManyToOne
    @JoinColumn(name = "floorId",
            nullable = false)
    private Floor floor;

    public Room() {
    }

    public Room(int id, String name, String description, String lighting, String music, int top, int left, int width, int height, Floor floor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lighting = lighting;
        this.music = music;
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
        this.floor = floor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
