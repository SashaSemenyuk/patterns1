package org.example;

import org.example.factory.ParserFactory;
import org.example.factory.TrainParserFactory;
import org.example.filters.GetNVehiclesAroundCurrentTime;
import org.example.parsers.XMLParser;
import org.example.print.TrainTablePrinter;
import org.example.print.VehicleTablePrinter;
import org.example.vehicle.list.VehicleList;
import org.example.vehicles.Vehicle;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        ParserFactory parser = new TrainParserFactory();
        XMLParser xmlParser = parser.createXMLParser();
        try {
            System.out.println("Before parsing file");
            List<Vehicle> trainList = xmlParser.parseFile("D:/Лабы ВДиШПВП/patterns1/src/main/java/org/example/xml/train.xml");
            System.out.println("After parsing file");

            trainList = GetNVehiclesAroundCurrentTime.getNVehiclesAroundCurrentTime(trainList, 5);
            System.out.println("Number of vehicles after parsing: " + trainList.size());


            VehicleList vehicles = new VehicleList(trainList);

            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }

            VehicleTablePrinter vehicleTablePrinter = new TrainTablePrinter();
            vehicleTablePrinter.printInfo(vehicles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
