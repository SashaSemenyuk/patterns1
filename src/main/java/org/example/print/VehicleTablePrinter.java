package org.example.print;

import org.example.vehicle.list.VehicleList;
import org.example.vehicles.Vehicle;

public interface VehicleTablePrinter {

    void printTableHeader();

    default void printVehicleList(VehicleList vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.printTableInfo();
        }
    }

    default void printInfo(VehicleList vehicles) {
        printTableHeader();
        printVehicleList(vehicles);
    }

}
