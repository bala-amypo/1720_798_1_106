package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceimpl implements LocationService {

    private final LocationRepository locationRepository;

    // ✅ Constructor order EXACT
    public LocationServiceimpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(Location location) {

        if (location.getRegion() == null || location.getRegion().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }

        return locationRepository.save(location);
    }

    @Override
    public Location getLocation(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
