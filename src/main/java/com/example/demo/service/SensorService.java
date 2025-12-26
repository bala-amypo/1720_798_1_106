package com.example.demo.service;

import com.example.demo.entity.Sensor;
import java.util.List;

public interface SensorService {
    Sensor create(Sensor sensor);
    List<Sensor> getAll();
}
