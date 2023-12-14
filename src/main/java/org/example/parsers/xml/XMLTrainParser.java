package org.example.parsers.xml;

import org.example.parsers.XMLParser;
import org.example.vehicles.Train;
import org.example.vehicles.Vehicle;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XMLTrainParser implements XMLParser {

    @Override
    public List<Vehicle> parseFile(String filePath) {
        List<Vehicle> trainList = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            NodeList trainNodes = document.getElementsByTagName("train");
            for (int i = 0; i < trainNodes.getLength(); i++) {
                Node trainNode = trainNodes.item(i);
                if (trainNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element trainElement = (Element) trainNode;
                    Train train = parseTrainElement(trainElement);
                    trainList.add(train);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trainList;
    }

    private Train parseTrainElement(Element trainElement) {
        int trainNumber = Integer.parseInt(getElementValue(trainElement, "trainNumber"));
        LocalDate departureDate = LocalDate.parse(getElementValue(trainElement, "departureDate"));
        String departureTime = getElementValue(trainElement, "departureTime");
        String destination = getElementValue(trainElement, "destination");
        String departureStation = getElementValue(trainElement, "departureStation");
        String departurePlatform = getElementValue(trainElement, "departurePlatform");
        String arrivalStation = getElementValue(trainElement, "arrivalStation");
        String ticketTypesAndCosts = getElementValue(trainElement, "ticketCost");
        LocalDate arrivalDate = LocalDate.parse(getElementValue(trainElement, "arrivalDate"));
        String arrivalTime = getElementValue(trainElement, "arrivalTime");

        return new Train(
                trainNumber,
                departureDate,
                departureTime,
                destination,
                departureStation,
                departurePlatform,
                arrivalStation,
                ticketTypesAndCosts,
                arrivalDate,
                arrivalTime
        );
    }


    private String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);

        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                return node.getTextContent();
            } else {
                // Handle the case where the node is null or not an element
                throw new RuntimeException("Invalid node for tag name " + tagName);
            }
        } else {
            // Handle the case where the element is not found
            // For example, you can log a warning or throw an exception
            throw new RuntimeException("Element with tag name " + tagName + " not found.");
        }
    }


}
