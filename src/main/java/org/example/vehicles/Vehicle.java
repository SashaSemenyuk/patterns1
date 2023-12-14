package org.example.vehicles;

import java.time.LocalDate;
import java.util.Date;

public interface Vehicle extends Comparable<Vehicle> {
    LocalDate getDepartureDate();
    String getDepartureTime();
    String getDeparturePlatform();
    default int compareTo(Vehicle vehicle) {
        return this.getDepartureTime().compareTo(vehicle.getDepartureTime());
    }

    void printTableInfo();
}
