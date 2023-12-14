package org.example.vehicle.list;

import org.example.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class VehicleList implements Iterable<Vehicle> {

    private final List<Vehicle> vehicles;

    public VehicleList() {
        vehicles = new ArrayList<>();
    }

    public VehicleList(List<Vehicle> vehicleList) {
        vehicles = vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    @Override
    public String toString() {
        return vehicles.toString();
    }

    private class VehicleIterator implements Iterator<Vehicle> {
        private int position;

        public VehicleIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < vehicles.size();
        }

        @Override
        public Vehicle next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return vehicles.get(position++);
        }
    }

}