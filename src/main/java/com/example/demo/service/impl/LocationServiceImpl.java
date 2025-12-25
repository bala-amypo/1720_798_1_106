package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo) {
        this.repo = repo;
    }

    @Override
    public Location createLocation(Location location) {
        return repo.save(location);
    }

    @Override
    public Location getLocation(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }
}
