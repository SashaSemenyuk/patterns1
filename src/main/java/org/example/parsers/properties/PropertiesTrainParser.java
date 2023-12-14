package org.example.parsers.properties;

import org.example.parsers.PropertiesParser;
import org.example.vehicles.Train;
import org.example.vehicles.Vehicle;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesTrainParser implements PropertiesParser {
    @Override
    public List<Vehicle> parseFile(String filePath) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(fis);

            // Iterate over properties and create Train objects
            int i = 1;
            while (properties.containsKey("train." + i + ".routeNumber")) {
                String routeNumberKey = "train." + i + ".routeNumber";
                String departureDateKey = "train." + i + ".departureDate";
                String departureTimeKey = "train." + i + ".departureTime";
                String destinationKey = "train." + i + ".destination";
                String departureStationKey = "train." + i + ".departureStation";
                String departurePlatformKey = "train." + i + ".departurePlatform";
                String arrivalStationKey = "train." + i + ".arrivalStation";
                String ticketCostKey = "train." + i + ".ticketCost";
                String trainBrandKey = "train." + i + ".trainBrand";
                String travelTimeKey = "train." + i + ".travelTime";

                if (properties.containsKey(routeNumberKey) &&
                        properties.containsKey(departureDateKey) &&
                        properties.containsKey(departureTimeKey) &&
                        properties.containsKey(destinationKey) &&
                        properties.containsKey(departureStationKey) &&
                        properties.containsKey(departurePlatformKey) &&
                        properties.containsKey(arrivalStationKey) &&
                        properties.containsKey(ticketCostKey) &&
                        properties.containsKey(trainBrandKey) &&
                        properties.containsKey(travelTimeKey)) {

                    int routeNumber = Integer.parseInt(properties.getProperty(routeNumberKey));
                    LocalDate departureDate = LocalDate.parse(properties.getProperty(departureDateKey));
                    String departureTime = properties.getProperty(departureTimeKey);
                    String destination = properties.getProperty(destinationKey);
                    String departureStation = properties.getProperty(departureStationKey);
                    String departurePlatform = properties.getProperty(departurePlatformKey);
                    String arrivalStation = properties.getProperty(arrivalStationKey);
                    double ticketCost = Double.parseDouble(properties.getProperty(ticketCostKey));
                    String trainBrand = properties.getProperty(trainBrandKey);
                    String travelTime = properties.getProperty(travelTimeKey);

//                    Train train = new Train(routeNumber, departureDate, departureTime, destination, departureStation,
//                            departurePlatform, arrivalStation, ticketCost, trainBrand, travelTime);
//
//                    vehicles.add(train);
                }

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}