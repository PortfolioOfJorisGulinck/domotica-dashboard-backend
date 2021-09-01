package be.jorisgulinck.domoticaspringbackend.controllers;

import be.jorisgulinck.domoticaspringbackend.models.building.Floor;
import be.jorisgulinck.domoticaspringbackend.models.building.Room;
import be.jorisgulinck.domoticaspringbackend.services.FloorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FloorController.class)
class FloorControllerTest {

    @MockBean
    private FloorService floorService;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private Floor floor;
    private List<Floor> floors;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                //.apply(springSecurity())
                .build();

        List<Room> rooms = new ArrayList<>(Arrays.asList(new Room(1), new Room(2)));
        floor = new Floor(20, "new floor", "/images/new-floor.jpg");
        floor.setRooms(rooms);
        floors = new ArrayList<>(Arrays.asList(floor));
    }

    @Test
    void addFloor() throws Exception {

        when(floorService.save(floor)).thenReturn(floor);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/floors")
                .content(asJsonString(floor))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    void updateFloor() throws Exception {

        when(floorService.save(floor)).thenReturn(floor);

        this.mockMvc.perform( MockMvcRequestBuilders
                .put("/floors/{id}", 2)
                .content(asJsonString(floor))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("new floor"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image").value("/images/new-floor.jpg"));
    }

    @Test
    void getAllFloors() throws Exception {

        when(floorService.getAll()).thenReturn(floors);

        this.mockMvc.perform( MockMvcRequestBuilders
                .get("/floors")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.floors").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.floors[*].id").isNotEmpty());
    }

    @Test
    void getFloor() throws Exception {

        when(floorService.getById(floor.getId())).thenReturn(floor);

        this.mockMvc.perform( MockMvcRequestBuilders
                .get("/floors/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(20));
    }

    @Test
    void deleteFloor() throws Exception {
        this.mockMvc.perform( MockMvcRequestBuilders
                .delete("/floors/{id}", 1) )
                .andExpect(status().isAccepted());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}