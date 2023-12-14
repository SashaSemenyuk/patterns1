package org.example.filters;

import org.example.vehicles.Vehicle;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


public class TimeFilter {
    public static List<Vehicle> filterByTime(List<Vehicle> vehicles, String time) {
        LocalTime filterTime = LocalTime.parse(time);

        return vehicles
                .stream()
                .filter(vehicle -> LocalTime.parse(vehicle.getDepartureTime()).isAfter(filterTime))
                .collect(Collectors.toList());
    }
}