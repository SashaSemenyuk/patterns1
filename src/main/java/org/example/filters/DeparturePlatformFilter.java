package org.example.filters;

import org.example.vehicles.Vehicle;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class DeparturePlatformFilter {
    public static List<Vehicle> filterByDeparturePlatform(List<Vehicle> vehicles, String departurePlatform) {
        return vehicles
                .stream()
                .filter(vehicle -> vehicle.getDeparturePlatform().equalsIgnoreCase(departurePlatform))
                .collect(Collectors.toList());
    }
}
