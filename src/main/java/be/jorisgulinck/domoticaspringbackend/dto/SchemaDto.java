package be.jorisgulinck.domoticaspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SchemaDto {

    private int id;
    private int roomId;
    private String service;
    private String amount;
    private String start;
    private String end;

}
