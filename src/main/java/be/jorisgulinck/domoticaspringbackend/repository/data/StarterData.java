package be.jorisgulinck.domoticaspringbackend.repository.data;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.domotica.Schema;
import be.jorisgulinck.domoticaspringbackend.domain.models.service.AutomationService;
import be.jorisgulinck.domoticaspringbackend.domain.models.service.ServiceType;
import be.jorisgulinck.domoticaspringbackend.domain.models.user.User;
import be.jorisgulinck.domoticaspringbackend.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class StarterData {

    public void fillDatabase(EntityManager entityManager) {

        // Basement
        Floor basement = new Floor();
        basement.setId(1);
        basement.setName("Kelder");
        basement.setImage("/images/kelder.jpg");

        // -- Room 1
        Room room1 = new Room();
        room1.setId(11);
        room1.setName("Wijnkelder");
        room1.setDescription("Deze wijnkelder bevat een collectie van unieke wijnen, daterend van 1940 tem 2020. De eigenaar is opgegroeid in de wijngaard van zijn vader te Duitsland. Deze wijnkelder bevat unieke Riesling wijnen om van te dromen.");

        List<AutomationService> servicesOfRoom1 = new ArrayList<>();
        AutomationService automationService1 = new AutomationService(1, ServiceType.LIGHTING, "8", room1);
        servicesOfRoom1.add(automationService1);
        AutomationService automationService2 = new AutomationService(2, ServiceType.MUSIC, "6", room1);
        servicesOfRoom1.add(automationService2);
        room1.setServices(servicesOfRoom1);

        Dimension dimension1 = new Dimension(1, 200, 200, room1);
        room1.setDimension(dimension1);
        Position position1 = new Position(1, 440, 240, room1);
        room1.setPosition(position1);
        room1.setFloor(basement);

        // -- Room 2
        Room room2 = new Room();
        room2.setId(12);
        room2.setName("Nutskamer");
        room2.setDescription("Deze ruimte bevat de boiler, electriciteitsmeter en waterstandmeter.");

        List<AutomationService> servicesOfRoom2 = new ArrayList<>();
        AutomationService automationService3 = new AutomationService(3, ServiceType.LIGHTING, "10", room2);
        servicesOfRoom2.add(automationService3);
        room2.setServices(servicesOfRoom2);

        Dimension dimension2 = new Dimension(2, 300, 300, room2);
        room2.setDimension(dimension2);
        Position position2 = new Position(2, 330, 787, room2);
        room2.setPosition(position2);
        room2.setFloor(basement);

        List<Room> roomsOfBasement = new ArrayList<>();
        roomsOfBasement.add(room1);
        roomsOfBasement.add(room2);
        basement.setRooms(roomsOfBasement);


        // Ground floor
        Floor groundFloor = new Floor();
        groundFloor.setId(2);
        groundFloor.setName("Gelijkvloers");
        groundFloor.setImage("/images/gelijkvloers.jpg");

        // -- Room 3
        Room room3 = new Room();
        room3.setId(21);
        room3.setName("Woonkamer");
        room3.setDescription("Deze woonkamer, in klassieke stijl, is speciaal ontworpen door de vrouw des huizes. Zij is afkomstig van Groot Brittanië en stond erop om deze kamer in een klassieke cottage stijl in te richten om zich thuis te kunnen voelen in Duitsland.");

        List<AutomationService> servicesOfRoom3 = new ArrayList<>();
        AutomationService automationService4 = new AutomationService(4, ServiceType.TEMPERATURE, "24", room3);
        servicesOfRoom3.add(automationService4);
        AutomationService automationService5 = new AutomationService(5, ServiceType.LIGHTING, "5", room3);
        servicesOfRoom3.add(automationService5);
        AutomationService automationService6 = new AutomationService(6, ServiceType.MUSIC, "5", room3);
        servicesOfRoom3.add(automationService6);
        AutomationService automationService7 = new AutomationService(7, ServiceType.CURTAINS, "closed", room3);
        servicesOfRoom3.add(automationService7);
        room3.setServices(servicesOfRoom3);

        Dimension dimension3 = new Dimension(3, 300, 250, room3);
        room3.setDimension(dimension3);
        Position position3 = new Position(3, 280, 390, room3);
        room3.setPosition(position3);
        room3.setFloor(groundFloor);

        // -- Room 4
        Room room4 = new Room();
        room4.setId(22);
        room4.setName("Keuken");
        room4.setDescription("Deze keuken is volledig ingericht met koelkast, twee ovens, microgofloven, vaatwasser en de nodige kasten.");

        List<AutomationService> servicesOfRoom4 = new ArrayList<>();
        AutomationService automationService8 = new AutomationService(8, ServiceType.TEMPERATURE, "10", room4);
        servicesOfRoom4.add(automationService8);
        AutomationService automationService9 = new AutomationService(9, ServiceType.LIGHTING, "13", room4);
        servicesOfRoom4.add(automationService9);
        AutomationService automationService10 = new AutomationService(10, ServiceType.MUSIC, "10", room4);
        servicesOfRoom4.add(automationService10);
        AutomationService automationService11 = new AutomationService(11, ServiceType.CURTAINS, "open", room4);
        servicesOfRoom4.add(automationService11);
        room4.setServices(servicesOfRoom4);

        Dimension dimension4 = new Dimension(4, 150, 155, room4);
        room4.setDimension(dimension4);
        Position position4 = new Position(4, 770, 570, room4);
        room4.setPosition(position4);
        room4.setFloor(groundFloor);

        // -- Room 5
        Room room5 = new Room();
        room5.setId(23);
        room5.setName("Gang");
        room5.setDescription("Dit is de gang waar de heer en vrouw des huizes hun eerste indruk kunnen maken op de gasten.");

        List<AutomationService> servicesOfRoom5 = new ArrayList<>();
        AutomationService automationService12 = new AutomationService(12, ServiceType.TEMPERATURE, "5", room5);
        servicesOfRoom5.add(automationService12);
        AutomationService automationService13 = new AutomationService(13, ServiceType.LIGHTING, "11", room5);
        servicesOfRoom5.add(automationService13);
        room5.setServices(servicesOfRoom5);

        Dimension dimension5 = new Dimension(5, 220, 155, room5);
        room5.setDimension(dimension5);
        Position position5 = new Position(5, 620, 230, room5);
        room5.setPosition(position5);
        room5.setFloor(groundFloor);

        // -- Room 6
        Room room6 = new Room();
        room6.setId(24);
        room6.setName("Gasten toilet");
        room6.setDescription("Deze toilet mag er best wezen. Steeds fris en schoon!");

        List<AutomationService> servicesOfRoom6 = new ArrayList<>();
        AutomationService automationService14 = new AutomationService(14, ServiceType.TEMPERATURE, "12", room6);
        servicesOfRoom6.add(automationService14);
        AutomationService automationService15 = new AutomationService(15, ServiceType.LIGHTING, "8", room6);
        servicesOfRoom6.add(automationService15);
        room6.setServices(servicesOfRoom6);

        Dimension dimension6 = new Dimension(6, 180, 155, room6);
        room6.setDimension(dimension6);
        Position position6 = new Position(6, 800, 200, room6);
        room6.setPosition(position6);
        room6.setFloor(groundFloor);

        List<Room> roomsOfGroundFloor = new ArrayList<>();
        roomsOfGroundFloor.add(room3);
        roomsOfGroundFloor.add(room4);
        roomsOfGroundFloor.add(room5);
        roomsOfGroundFloor.add(room6);
        groundFloor.setRooms(roomsOfGroundFloor);


        // First Floor
        Floor firstFloor = new Floor();
        firstFloor.setId(3);
        firstFloor.setName("1e verdiep");
        firstFloor.setImage("/images/eerste-verdiep.jpg");

        // -- Room 7
        Room room7 = new Room();
        room7.setId(31);
        room7.setName("Slaapkamer 1");
        room7.setDescription("Dit is de slaapkamer van de heer en vrouw des huizes. Rustig en ruim gelegen.");

        List<AutomationService> servicesOfRoom7 = new ArrayList<>();
        AutomationService automationService16 = new AutomationService(16, ServiceType.TEMPERATURE, "14", room7);
        servicesOfRoom7.add(automationService16);
        AutomationService automationService17 = new AutomationService(17, ServiceType.LIGHTING, "13", room7);
        servicesOfRoom7.add(automationService17);
        AutomationService automationService18 = new AutomationService(18, ServiceType.MUSIC, "9", room7);
        servicesOfRoom7.add(automationService18);
        AutomationService automationService19 = new AutomationService(19, ServiceType.CURTAINS, "open", room7);
        servicesOfRoom7.add(automationService19);
        room7.setServices(servicesOfRoom7);

        Dimension dimension7 = new Dimension(7, 300, 300, room7);
        room7.setDimension(dimension7);
        Position position7 = new Position(7, 685, 490, room7);
        room7.setPosition(position7);
        room7.setFloor(firstFloor);

        // -- Room 8
        Room room8 = new Room();
        room8.setId(32);
        room8.setName("Slaapkamer 2");
        room8.setDescription("Dit is de slaapkamer van de dochter. Je verveelt je hier nooit. Teveel speelgoed om op te sommen...");

        List<AutomationService> servicesOfRoom8 = new ArrayList<>();
        AutomationService automationService20 = new AutomationService(20, ServiceType.TEMPERATURE, "4", room8);
        servicesOfRoom8.add(automationService20);
        AutomationService automationService21 = new AutomationService(21, ServiceType.LIGHTING, "3", room8);
        servicesOfRoom8.add(automationService21);
        AutomationService automationService22 = new AutomationService(22, ServiceType.MUSIC, "6", room8);
        servicesOfRoom8.add(automationService22);
        AutomationService automationService23 = new AutomationService(23, ServiceType.CURTAINS, "closed", room8);
        servicesOfRoom8.add(automationService23);
        room8.setServices(servicesOfRoom8);

        Dimension dimension8 = new Dimension(8, 220, 200, room8);
        room8.setDimension(dimension8);
        Position position8 = new Position(8, 240, 130, room8);
        room8.setPosition(position8);
        room8.setFloor(firstFloor);

        // -- Room 9
        Room room9 = new Room();
        room9.setId(33);
        room9.setName("Badkamer");
        room9.setDescription("Deze badkamer bevat een douche, bad en twee lavabo's.");

        List<AutomationService> servicesOfRoom9 = new ArrayList<>();
        AutomationService automationService24 = new AutomationService(24, ServiceType.TEMPERATURE, "4", room9);
        servicesOfRoom9.add(automationService24);
        AutomationService automationService25 = new AutomationService(25, ServiceType.LIGHTING, "0", room9);
        servicesOfRoom9.add(automationService25);
        AutomationService automationService26 = new AutomationService(26, ServiceType.MUSIC, "10", room9);
        servicesOfRoom9.add(automationService26);
        AutomationService automationService27 = new AutomationService(27, ServiceType.CURTAINS, "open", room9);
        servicesOfRoom9.add(automationService27);
        room9.setServices(servicesOfRoom9);

        Dimension dimension9 = new Dimension(9, 160, 155, room9);
        room9.setDimension(dimension9);
        Position position9 = new Position(9, 750, 200, room9);
        room9.setPosition(position9);
        room9.setFloor(firstFloor);

        // -- Room 10
        Room room10 = new Room();
        room10.setId(34);
        room10.setName("Toilet");
        room10.setDescription("Een toilet vol met interessante lectuur om de stoelgang te bevorderen.");

        List<AutomationService> servicesOfRoom10 = new ArrayList<>();
        AutomationService automationService28 = new AutomationService(28, ServiceType.TEMPERATURE, "10", room10);
        servicesOfRoom10.add(automationService28);
        AutomationService automationService29 = new AutomationService(29, ServiceType.LIGHTING, "8", room10);
        servicesOfRoom10.add(automationService29);
        room10.setServices(servicesOfRoom10);

        Dimension dimension10 = new Dimension(10, 150, 155, room10);
        room10.setDimension(dimension10);
        Position position10 = new Position(10, 480, 242, room10);
        room10.setPosition(position10);
        room10.setFloor(firstFloor);

        List<Room> roomsOfFirstFloor = new ArrayList<>();
        roomsOfFirstFloor.add(room7);
        roomsOfFirstFloor.add(room8);
        roomsOfFirstFloor.add(room9);
        roomsOfFirstFloor.add(room10);
        firstFloor.setRooms(roomsOfFirstFloor);


        // Attic
        Floor attic = new Floor();
        attic.setId(4);
        attic.setName("Zolder");
        attic.setImage("/images/zolder.jpg");

        // -- Room 11
        Room room11 = new Room();
        room11.setId(41);
        room11.setName("Zolder ruimte");
        room11.setDescription("Deze zolder is de speelruimte voor de kinderen. Hier bouwen ze kampen en spelen ze toneel.");

        List<AutomationService> servicesOfRoom11 = new ArrayList<>();
        AutomationService automationService30 = new AutomationService(30, ServiceType.LIGHTING, "5", room11);
        servicesOfRoom11.add(automationService30);
        AutomationService automationService31 = new AutomationService(31, ServiceType.MUSIC, "2", room11);
        servicesOfRoom11.add(automationService31);
        room11.setServices(servicesOfRoom11);

        Dimension dimension11 = new Dimension(11, 400, 200, room11);
        room11.setDimension(dimension11);
        Position position11 = new Position(11, 323, 353, room11);
        room11.setPosition(position11);
        room11.setFloor(attic);


        // schemes
        Schema schema1 = new Schema();
        schema1.setId(1);
        schema1.setRoom(room4);
        AutomationService automationService32 = new AutomationService(32, ServiceType.CURTAINS, "open", schema1);
        schema1.setService(automationService32);
        schema1.setStart("14:00");
        schema1.setEnd("09:00");

        List<Schema> schemesOfRoom4 = new ArrayList<>();
        schemesOfRoom4.add(schema1);

        Schema schema2 = new Schema();
        schema2.setId(2);
        schema2.setRoom(room1);
        AutomationService automationService33 = new AutomationService(33, ServiceType.LIGHTING, "0", schema2);
        schema2.setService(automationService33);
        schema2.setStart("14:00");
        schema2.setEnd("10:00");

        List<Schema> schemesOfRoom1 = new ArrayList<>();
        schemesOfRoom1.add(schema2);

        Schema schema3 = new Schema();
        schema3.setId(3);
        schema3.setRoom(room4);
        AutomationService automationService34 = new AutomationService(34, ServiceType.TEMPERATURE, "11", schema3);
        schema3.setService(automationService34);
        schema3.setStart("08:00");
        schema3.setEnd("11:00");

        schemesOfRoom4.add(schema3);

        Schema schema4 = new Schema();
        schema4.setId(4);
        schema4.setRoom(room4);
        AutomationService automationService35 = new AutomationService(35, ServiceType.CURTAINS, "closed", schema4);
        schema4.setService(automationService35);
        schema4.setStart("14:00");
        schema4.setEnd("18:00");

        schemesOfRoom4.add(schema4);

        room1.setSchemes(schemesOfRoom1);
        room4.setSchemes(schemesOfRoom4);


        // Saving to the database
        entityManager.persist(basement);
        entityManager.persist(groundFloor);
        entityManager.persist(firstFloor);
        entityManager.persist(attic);

        /*
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


        entityManager.persist(automationService1);
        entityManager.persist(automationService2);
        entityManager.persist(automationService3);
        entityManager.persist(automationService4);
        entityManager.persist(automationService5);
        entityManager.persist(automationService6);
        entityManager.persist(automationService7);
        entityManager.persist(automationService8);
        entityManager.persist(automationService9);
        entityManager.persist(automationService10);
        entityManager.persist(automationService11);
        entityManager.persist(automationService12);
        entityManager.persist(automationService13);
        entityManager.persist(automationService14);
        entityManager.persist(automationService15);
        entityManager.persist(automationService16);
        entityManager.persist(automationService17);
        entityManager.persist(automationService18);
        entityManager.persist(automationService19);
        entityManager.persist(automationService20);
        entityManager.persist(automationService21);
        entityManager.persist(automationService22);
        entityManager.persist(automationService23);
        entityManager.persist(automationService24);
        entityManager.persist(automationService25);
        entityManager.persist(automationService26);
        entityManager.persist(automationService27);
        entityManager.persist(automationService28);
        entityManager.persist(automationService29);
        entityManager.persist(automationService30);
        entityManager.persist(automationService31);
        entityManager.persist(automationService32);
        entityManager.persist(automationService33);
        entityManager.persist(automationService34);
        entityManager.persist(automationService35);


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


        entityManager.persist(schema1);
        entityManager.persist(schema2);
        entityManager.persist(schema3);
        entityManager.persist(schema4);

         */
    }

    public void createUser(UserRepository userRepository){
        // User
        User user = new User(1, "user", "user", true, "USER");
        userRepository.save(user);
    }
}
