package be.jorisgulinck.domoticaspringbackend.repository.data;

import be.jorisgulinck.domoticaspringbackend.domain.models.building.Dimension;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Position;
import be.jorisgulinck.domoticaspringbackend.domain.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.domain.models.schema.Schema;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.AutomationDevice;
import be.jorisgulinck.domoticaspringbackend.domain.models.device.DeviceType;
import be.jorisgulinck.domoticaspringbackend.domain.models.user.User;

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

        List<AutomationDevice> servicesOfRoom1 = new ArrayList<>();
        AutomationDevice automationDevice1 = new AutomationDevice(1, DeviceType.LIGHTING, "8", room1);
        servicesOfRoom1.add(automationDevice1);
        AutomationDevice automationDevice2 = new AutomationDevice(2, DeviceType.MUSIC, "6", room1);
        servicesOfRoom1.add(automationDevice2);
        room1.setAutomationDevices(servicesOfRoom1);

        Dimension dimension1 = new Dimension(1, 200, 200);
        room1.setDimension(dimension1);
        Position position1 = new Position(1, 440, 240);
        room1.setPosition(position1);
        room1.setFloor(basement);

        // -- Room 2
        Room room2 = new Room();
        room2.setId(12);
        room2.setName("Nutskamer");
        room2.setDescription("Deze ruimte bevat de boiler, electriciteitsmeter en waterstandmeter.");

        List<AutomationDevice> servicesOfRoom2 = new ArrayList<>();
        AutomationDevice automationDevice3 = new AutomationDevice(3, DeviceType.LIGHTING, "10", room2);
        servicesOfRoom2.add(automationDevice3);
        room2.setAutomationDevices(servicesOfRoom2);

        Dimension dimension2 = new Dimension(2, 300, 300);
        room2.setDimension(dimension2);
        Position position2 = new Position(2, 330, 787);
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

        List<AutomationDevice> servicesOfRoom3 = new ArrayList<>();
        AutomationDevice automationDevice4 = new AutomationDevice(4, DeviceType.TEMPERATURE, "24", room3);
        servicesOfRoom3.add(automationDevice4);
        AutomationDevice automationDevice5 = new AutomationDevice(5, DeviceType.LIGHTING, "5", room3);
        servicesOfRoom3.add(automationDevice5);
        AutomationDevice automationDevice6 = new AutomationDevice(6, DeviceType.MUSIC, "5", room3);
        servicesOfRoom3.add(automationDevice6);
        AutomationDevice automationDevice7 = new AutomationDevice(7, DeviceType.CURTAINS, "closed", room3);
        servicesOfRoom3.add(automationDevice7);
        room3.setAutomationDevices(servicesOfRoom3);

        Dimension dimension3 = new Dimension(3, 300, 250);
        room3.setDimension(dimension3);
        Position position3 = new Position(3, 280, 390);
        room3.setPosition(position3);
        room3.setFloor(groundFloor);

        // -- Room 4
        Room room4 = new Room();
        room4.setId(22);
        room4.setName("Keuken");
        room4.setDescription("Deze keuken is volledig ingericht met koelkast, twee ovens, microgofloven, vaatwasser en de nodige kasten.");

        List<AutomationDevice> servicesOfRoom4 = new ArrayList<>();
        AutomationDevice automationDevice8 = new AutomationDevice(8, DeviceType.TEMPERATURE, "10", room4);
        servicesOfRoom4.add(automationDevice8);
        AutomationDevice automationDevice9 = new AutomationDevice(9, DeviceType.LIGHTING, "13", room4);
        servicesOfRoom4.add(automationDevice9);
        AutomationDevice automationDevice10 = new AutomationDevice(10, DeviceType.MUSIC, "10", room4);
        servicesOfRoom4.add(automationDevice10);
        AutomationDevice automationDevice11 = new AutomationDevice(11, DeviceType.CURTAINS, "open", room4);
        servicesOfRoom4.add(automationDevice11);
        room4.setAutomationDevices(servicesOfRoom4);

        Dimension dimension4 = new Dimension(4, 150, 155);
        room4.setDimension(dimension4);
        Position position4 = new Position(4, 770, 570);
        room4.setPosition(position4);
        room4.setFloor(groundFloor);

        // -- Room 5
        Room room5 = new Room();
        room5.setId(23);
        room5.setName("Gang");
        room5.setDescription("Dit is de gang waar de heer en vrouw des huizes hun eerste indruk kunnen maken op de gasten.");

        List<AutomationDevice> servicesOfRoom5 = new ArrayList<>();
        AutomationDevice automationDevice12 = new AutomationDevice(12, DeviceType.TEMPERATURE, "5", room5);
        servicesOfRoom5.add(automationDevice12);
        AutomationDevice automationDevice13 = new AutomationDevice(13, DeviceType.LIGHTING, "11", room5);
        servicesOfRoom5.add(automationDevice13);
        room5.setAutomationDevices(servicesOfRoom5);

        Dimension dimension5 = new Dimension(5, 220, 155);
        room5.setDimension(dimension5);
        Position position5 = new Position(5, 620, 230);
        room5.setPosition(position5);
        room5.setFloor(groundFloor);

        // -- Room 6
        Room room6 = new Room();
        room6.setId(24);
        room6.setName("Gasten toilet");
        room6.setDescription("Deze toilet mag er best wezen. Steeds fris en schoon!");

        List<AutomationDevice> servicesOfRoom6 = new ArrayList<>();
        AutomationDevice automationDevice14 = new AutomationDevice(14, DeviceType.TEMPERATURE, "12", room6);
        servicesOfRoom6.add(automationDevice14);
        AutomationDevice automationDevice15 = new AutomationDevice(15, DeviceType.LIGHTING, "8", room6);
        servicesOfRoom6.add(automationDevice15);
        room6.setAutomationDevices(servicesOfRoom6);

        Dimension dimension6 = new Dimension(6, 180, 155);
        room6.setDimension(dimension6);
        Position position6 = new Position(6, 800, 200);
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

        List<AutomationDevice> servicesOfRoom7 = new ArrayList<>();
        AutomationDevice automationDevice16 = new AutomationDevice(16, DeviceType.TEMPERATURE, "14", room7);
        servicesOfRoom7.add(automationDevice16);
        AutomationDevice automationDevice17 = new AutomationDevice(17, DeviceType.LIGHTING, "13", room7);
        servicesOfRoom7.add(automationDevice17);
        AutomationDevice automationDevice18 = new AutomationDevice(18, DeviceType.MUSIC, "9", room7);
        servicesOfRoom7.add(automationDevice18);
        AutomationDevice automationDevice19 = new AutomationDevice(19, DeviceType.CURTAINS, "open", room7);
        servicesOfRoom7.add(automationDevice19);
        room7.setAutomationDevices(servicesOfRoom7);

        Dimension dimension7 = new Dimension(7, 300, 300);
        room7.setDimension(dimension7);
        Position position7 = new Position(7, 685, 490);
        room7.setPosition(position7);
        room7.setFloor(firstFloor);

        // -- Room 8
        Room room8 = new Room();
        room8.setId(32);
        room8.setName("Slaapkamer 2");
        room8.setDescription("Dit is de slaapkamer van de dochter. Je verveelt je hier nooit. Teveel speelgoed om op te sommen...");

        List<AutomationDevice> servicesOfRoom8 = new ArrayList<>();
        AutomationDevice automationDevice20 = new AutomationDevice(20, DeviceType.TEMPERATURE, "4", room8);
        servicesOfRoom8.add(automationDevice20);
        AutomationDevice automationDevice21 = new AutomationDevice(21, DeviceType.LIGHTING, "3", room8);
        servicesOfRoom8.add(automationDevice21);
        AutomationDevice automationDevice22 = new AutomationDevice(22, DeviceType.MUSIC, "6", room8);
        servicesOfRoom8.add(automationDevice22);
        AutomationDevice automationDevice23 = new AutomationDevice(23, DeviceType.CURTAINS, "closed", room8);
        servicesOfRoom8.add(automationDevice23);
        room8.setAutomationDevices(servicesOfRoom8);

        Dimension dimension8 = new Dimension(8, 220, 200);
        room8.setDimension(dimension8);
        Position position8 = new Position(8, 240, 130);
        room8.setPosition(position8);
        room8.setFloor(firstFloor);

        // -- Room 9
        Room room9 = new Room();
        room9.setId(33);
        room9.setName("Badkamer");
        room9.setDescription("Deze badkamer bevat een douche, bad en twee lavabo's.");

        List<AutomationDevice> servicesOfRoom9 = new ArrayList<>();
        AutomationDevice automationDevice24 = new AutomationDevice(24, DeviceType.TEMPERATURE, "4", room9);
        servicesOfRoom9.add(automationDevice24);
        AutomationDevice automationDevice25 = new AutomationDevice(25, DeviceType.LIGHTING, "0", room9);
        servicesOfRoom9.add(automationDevice25);
        AutomationDevice automationDevice26 = new AutomationDevice(26, DeviceType.MUSIC, "10", room9);
        servicesOfRoom9.add(automationDevice26);
        AutomationDevice automationDevice27 = new AutomationDevice(27, DeviceType.CURTAINS, "open", room9);
        servicesOfRoom9.add(automationDevice27);
        room9.setAutomationDevices(servicesOfRoom9);

        Dimension dimension9 = new Dimension(9, 160, 155);
        room9.setDimension(dimension9);
        Position position9 = new Position(9, 750, 200);
        room9.setPosition(position9);
        room9.setFloor(firstFloor);

        // -- Room 10
        Room room10 = new Room();
        room10.setId(34);
        room10.setName("Toilet");
        room10.setDescription("Een toilet vol met interessante lectuur om de stoelgang te bevorderen.");

        List<AutomationDevice> servicesOfRoom10 = new ArrayList<>();
        AutomationDevice automationDevice28 = new AutomationDevice(28, DeviceType.TEMPERATURE, "10", room10);
        servicesOfRoom10.add(automationDevice28);
        AutomationDevice automationDevice29 = new AutomationDevice(29, DeviceType.LIGHTING, "8", room10);
        servicesOfRoom10.add(automationDevice29);
        room10.setAutomationDevices(servicesOfRoom10);

        Dimension dimension10 = new Dimension(10, 150, 155);
        room10.setDimension(dimension10);
        Position position10 = new Position(10, 480, 242);
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

        List<AutomationDevice> servicesOfRoom11 = new ArrayList<>();
        AutomationDevice automationDevice30 = new AutomationDevice(30, DeviceType.LIGHTING, "5", room11);
        servicesOfRoom11.add(automationDevice30);
        AutomationDevice automationDevice31 = new AutomationDevice(31, DeviceType.MUSIC, "2", room11);
        servicesOfRoom11.add(automationDevice31);
        room11.setAutomationDevices(servicesOfRoom11);

        Dimension dimension11 = new Dimension(11, 400, 200);
        room11.setDimension(dimension11);
        Position position11 = new Position(11, 323, 353);
        room11.setPosition(position11);
        room11.setFloor(attic);


        // schemes
        Schema schema1 = new Schema();
        schema1.setId(1);
        schema1.setRoom(room4);
        AutomationDevice automationDevice32 = new AutomationDevice(32, DeviceType.CURTAINS, "open", room4);
        schema1.setAutomationDevice(automationDevice32);
        schema1.setStart("14:00");
        schema1.setEnd("09:00");

        List<Schema> schemesOfRoom4 = new ArrayList<>();
        schemesOfRoom4.add(schema1);

        Schema schema2 = new Schema();
        schema2.setId(2);
        schema2.setRoom(room1);
        AutomationDevice automationDevice33 = new AutomationDevice(33, DeviceType.LIGHTING, "0", room1);
        schema2.setAutomationDevice(automationDevice33);
        schema2.setStart("14:00");
        schema2.setEnd("10:00");

        List<Schema> schemesOfRoom1 = new ArrayList<>();
        schemesOfRoom1.add(schema2);

        Schema schema3 = new Schema();
        schema3.setId(3);
        schema3.setRoom(room4);
        AutomationDevice automationDevice34 = new AutomationDevice(34, DeviceType.TEMPERATURE, "11", room4);
        schema3.setAutomationDevice(automationDevice34);
        schema3.setStart("08:00");
        schema3.setEnd("11:00");

        schemesOfRoom4.add(schema3);

        Schema schema4 = new Schema();
        schema4.setId(4);
        schema4.setRoom(room4);
        AutomationDevice automationDevice35 = new AutomationDevice(35, DeviceType.CURTAINS, "closed", room4);
        schema4.setAutomationDevice(automationDevice35);
        schema4.setStart("14:00");
        schema4.setEnd("18:00");

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

        entityManager.merge(automationDevice1);
        entityManager.merge(automationDevice2);
        entityManager.merge(automationDevice3);
        entityManager.merge(automationDevice4);
        entityManager.merge(automationDevice5);
        entityManager.merge(automationDevice6);
        entityManager.merge(automationDevice7);
        entityManager.merge(automationDevice8);
        entityManager.merge(automationDevice9);
        entityManager.merge(automationDevice10);
        entityManager.merge(automationDevice11);
        entityManager.merge(automationDevice12);
        entityManager.merge(automationDevice13);
        entityManager.merge(automationDevice14);
        entityManager.merge(automationDevice15);
        entityManager.merge(automationDevice16);
        entityManager.merge(automationDevice17);
        entityManager.merge(automationDevice18);
        entityManager.merge(automationDevice19);
        entityManager.merge(automationDevice20);
        entityManager.merge(automationDevice21);
        entityManager.merge(automationDevice22);
        entityManager.merge(automationDevice23);
        entityManager.merge(automationDevice24);
        entityManager.merge(automationDevice25);
        entityManager.merge(automationDevice26);
        entityManager.merge(automationDevice27);
        entityManager.merge(automationDevice28);
        entityManager.merge(automationDevice29);
        entityManager.merge(automationDevice30);

        entityManager.merge(automationDevice31);
        entityManager.merge(automationDevice32);
        entityManager.merge(automationDevice33);
        entityManager.merge(automationDevice34);
        entityManager.merge(automationDevice35);

        entityManager.merge(schema1);
        entityManager.merge(schema2);
        entityManager.merge(schema3);
        entityManager.merge(schema4);

    }
}
