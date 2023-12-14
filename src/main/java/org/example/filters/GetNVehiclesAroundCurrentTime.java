package org.example.filters;

import org.example.vehicles.Vehicle;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class GetNVehiclesAroundCurrentTime {

    public static List<Vehicle> getNVehiclesAroundCurrentTime(List<Vehicle> vehicles, int n) {

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        List<Vehicle> filteredVehicles = TimeFilter.filterByTime(vehicles, currentTime.toString())
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return (n >= filteredVehicles.size()) ? filteredVehicles : filteredVehicles.subList(0, n);
    }
}