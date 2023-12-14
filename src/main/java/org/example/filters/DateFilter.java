package org.example.filters;

import org.example.vehicles.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DateFilter {
    public static List<Vehicle> filterByDate(List<Vehicle> vehicles, LocalDate date) {
        return vehicles
                .stream()
                .filter(vehicle -> vehicle.getDepartureDate().isAfter(date))
                .collect(Collectors.toList());
    }
}
