package be.jorisgulinck.domoticaspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FloorDto {

    private int id;
    private String name;
    private String image;
    private List<Integer> rooms;

}
