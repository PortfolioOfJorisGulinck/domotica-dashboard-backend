package be.jorisgulinck.domoticaspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDto {

    private int id;
    private String name;
    private String description;
    private String temperature;
    private String lighting;
    private String music;
    private String curtains;
    private int top;
    private int left;
    private int width;
    private int height;
    private int floorId;

}