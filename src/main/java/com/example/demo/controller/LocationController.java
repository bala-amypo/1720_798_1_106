package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Locations Endpoints")
public class LocationController {

    @PostMapping
    public String createLocation() {
        return "Location created";
    }

    @GetMapping
    public String listLocations() {
        return "List of locations";
    }

    @GetMapping("/{id}")
    public String getLocation(@PathVariable Long id) {
        return "Location details for id: " + id;
    }
}
