package be.jorisgulinck.domoticaspringbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO dummy controller to be removed
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello";
    }
}