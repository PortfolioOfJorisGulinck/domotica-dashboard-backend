package be.jorisgulinck.domoticaspringbackend.repository.data;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.domain.models.user.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StarterData {

    public void fillDatabase(EntityManager entityManager) {

        // Basement
        Floor basement = new Floor(
                1,
                "Kelder",
                "/images/kelder.jpg"
        );

        // -- Room 1
        Dimension dimension1 = new Dimension(1, 200, 200);
        Position position1 = new Position(1, 440, 240);

        Room room1 = new Room(
                11,
                "Wijnkelder",
                "Deze wijnkelder bevat een collectie van unieke wijnen, daterend van 1940 tem 2020. De eigenaar is opgegroeid in de wijngaard van zijn vader te Duitsland. Deze wijnkelder bevat unieke Riesling wijnen om van te dromen.",
                null,
                "8",
                "6",
                null,
                dimension1,
                position1,
                basement
        );

        // -- Room 2
        Dimension dimension2 = new Dimension(2, 300, 300);
        Position position2 = new Position(2, 330, 787);

        Room room2 = new Room(
                12,
                "Nutskamer",
                "Deze ruimte bevat de boiler, electriciteitsmeter en waterstandmeter.",
                null,
                "10",
                null,
                null,
                dimension2,
                position2,
                basement
        );

        List<Room> roomsOfBasement = new ArrayList<>(Arrays.asList(room1, room2));
        basement.setRooms(roomsOfBasement);


        // Ground floor
        Floor groundFloor = new Floor(
                2,
                "Gelijkvloers",
                "/images/gelijkvloers.jpg"
        );

        // -- Room 3
        Dimension dimension3 = new Dimension(3, 300, 250);
        Position position3 = new Position(3, 280, 390);

        Room room3 = new Room(
                21,
                "Woonkamer",
                "Deze woonkamer, in klassieke stijl, is speciaal ontworpen door de vrouw des huizes. Zij is afkomstig van Groot Brittanië en stond erop om deze kamer in een klassieke cottage stijl in te richten om zich thuis te kunnen voelen in Duitsland.",
                "24",
                "5",
                "5",
                "false",
                dimension3,
                position3,
                groundFloor
        );

        // -- Room 4
        Dimension dimension4 = new Dimension(4, 150, 155);
        Position position4 = new Position(4, 770, 570);

        Room room4 = new Room(
                22,
                "Keuken",
                "Deze keuken is volledig ingericht met koelkast, twee ovens, microgofloven, vaatwasser en de nodige kasten.",
                "10",
                "13",
                "10",
                "true",
                dimension4,
                position4,
                groundFloor
        );

        // -- Room 5
        Dimension dimension5 = new Dimension(5, 220, 155);
        Position position5 = new Position(5, 620, 230);

        Room room5 = new Room(
                23,
                "Gang",
                "Dit is de gang waar de heer en vrouw des huizes hun eerste indruk kunnen maken op de gasten.",
                "5",
                "11",
                null,
                null,
                dimension5,
                position5,
                groundFloor
        );

        // -- Room 6
        Dimension dimension6 = new Dimension(6, 180, 155);
        Position position6 = new Position(6, 800, 200);

        Room room6 = new Room(
                24,
                "Gasten toilet",
                "Deze toilet mag er best wezen. Steeds fris en schoon!",
                "12",
                "8",
                null,
                null,
                dimension6,
                position6,
                groundFloor
        );

        List<Room> roomsOfGroundFloor = new ArrayList<>(Arrays.asList(room3, room4, room5, room6));
        groundFloor.setRooms(roomsOfGroundFloor);


        // First Floor
        Floor firstFloor = new Floor(
                3,
                "1e verdiep",
                "/images/eerste-verdiep.jpg"
        );

        // -- Room 7
        Dimension dimension7 = new Dimension(7, 300, 300);
        Position position7 = new Position(7, 685, 490);

        Room room7 = new Room(
                31,
                "Slaapkamer 1",
                "Dit is de slaapkamer van de heer en vrouw des huizes. Rustig en ruim gelegen.",
                "14",
                "13",
                "9",
                "true",
                dimension7,
                position7,
                firstFloor
        );

        // -- Room 8
        Dimension dimension8 = new Dimension(8, 220, 200);
        Position position8 = new Position(8, 240, 130);

        Room room8 = new Room(
                32,
                "Slaapkamer 2",
                "Dit is de slaapkamer van de dochter. Je verveelt je hier nooit. Teveel speelgoed om op te sommen...",
                "4",
                "3",
                "6",
                "false",
                dimension8,
                position8,
                firstFloor
        );

        // -- Room 9
        Dimension dimension9 = new Dimension(9, 160, 155);
        Position position9 = new Position(9, 750, 200);

        Room room9 = new Room(
                33,
                "Badkamer",
                "Deze badkamer bevat een douche, bad en twee lavabo's.",
                "4",
                "0",
                "10",
                "true",
                dimension9,
                position9,
                firstFloor
        );

        // -- Room 10
        Dimension dimension10 = new Dimension(10, 150, 155);
        Position position10 = new Position(10, 480, 242);

        Room room10 = new Room(
                34,
                "Toilet",
                "Een toilet vol met interessante lectuur om de stoelgang te bevorderen.",
                "10",
                "8",
                null,
                null,
                dimension10,
                position10,
                firstFloor
        );


        // Attic
        Floor attic = new Floor(
                4,
                "Zolder",
                "/images/zolder.jpg"
        );

        // -- Room 11
        Dimension dimension11 = new Dimension(11, 400, 200);
        Position position11 = new Position(11, 323, 353);

        Room room11 = new Room(
                41,
                "Zolder ruimte",
                "Deze zolder is de speelruimte voor de kinderen. Hier bouwen ze kampen en spelen ze toneel.",
                null,
                "5",
                "2",
                null,
                dimension11,
                position11,
                attic
        );

        // schemes
        Schema schema1 = new Schema(
                "14:00",
                "09:00",
                "curtains",
                "true",
                room4
        );

        List<Schema> schemesOfRoom4 = new ArrayList<>();
        schemesOfRoom4.add(schema1);

        Schema schema2 = new Schema(
                "14:00",
                "16:00",
                "lighting",
                "0",
                room1
        );

        List<Schema> schemesOfRoom1 = new ArrayList<>();
        schemesOfRoom1.add(schema2);

        Schema schema3 = new Schema(
                "08:00",
                "11:00",
                "temperature",
                "11",
                room4
        );

        schemesOfRoom4.add(schema3);

        Schema schema4 = new Schema(
                "14:00",
                "18:00",
                "curtains",
                "Dicht",
                room4
        );

        schemesOfRoom4.add(schema4);

        room1.setSchemes(schemesOfRoom1);
        room4.setSchemes(schemesOfRoom4);


        // Users
        User user = new User(1, "user", "user", true, "USER");


        // Saving to the database
        entityManager.persist(user);

        entityManager.persist(basement);
        entityManager.persist(groundFloor);
        entityManager.persist(firstFloor);
        entityManager.persist(attic);

        entityManager.persist(dimension1);
        entityManager.persist(dimension2);
        entityManager.persist(dimension3);
        entityManager.persist(dimension4);
        entityManager.persist(dimension5);
        entityManager.persist(dimension6);
        entityManager.persist(dimension7);
        entityManager.persist(dimension8);
        entityManager.persist(dimension9);
        entityManager.persist(dimension10);
        entityManager.persist(dimension11);

        entityManager.persist(position1);
        entityManager.persist(position2);
        entityManager.persist(position3);
        entityManager.persist(position4);
        entityManager.persist(position5);
        entityManager.persist(position6);
        entityManager.persist(position7);
        entityManager.persist(position8);
        entityManager.persist(position9);
        entityManager.persist(position10);
        entityManager.persist(position11);

        entityManager.persist(room1);
        entityManager.persist(room2);
        entityManager.persist(room3);
        entityManager.persist(room4);
        entityManager.persist(room5);
        entityManager.persist(room6);
        entityManager.persist(room7);
        entityManager.persist(room8);
        entityManager.persist(room9);
        entityManager.persist(room10);
        entityManager.persist(room11);

        entityManager.persist(schema1);
        entityManager.persist(schema2);
        entityManager.persist(schema3);
        entityManager.persist(schema4);
    }
}
