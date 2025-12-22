package com.example.demo.service;

import com.example.demo.model.Location;

import java.util.List;

public interface LocationService {

    Location createLocation(Location location);

    List<Location> getAllLocations();

    Location getLocationById(Long id);
}
