package org.example.parsers;

import org.example.vehicles.Vehicle;

import java.util.List;

public interface XMLParser {
    public List<Vehicle> parseFile(String filePath);
}
