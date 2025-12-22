package com.example.demo.controller;

import com.example.demo.model.Location;
import com.example.demo.service.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Locations Endpoints")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // ✅ CREATE location (returns object with ID)
    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    // ✅ GET all locations (returns list with IDs)
    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    // ✅ GET location by ID
    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }
}
