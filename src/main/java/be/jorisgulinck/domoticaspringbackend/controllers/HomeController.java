package be.jorisgulinck.domoticaspringbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the domotica api! You can find mappings to the following urls: /floors, /rooms, /schemes";
    }
}