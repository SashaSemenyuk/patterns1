package org.example.vehicles;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.table.format.TableFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Train implements Vehicle {

    private int trainNumber;
    private LocalDate departureDate;
    private String departureTime;
    private String destination;
    private String departureStation;
    private String departurePlatform;
    private String arrivalStation;
    private String ticketTypesAndCosts;
    private LocalDate arrivalDate;
    private String arrivalTime;

    @Override
    public void printTableInfo() {

        TableFormat tableFormat = TableFormat.getTableFormat();
        String format = tableFormat.getFormat();

        System.out.printf(format, getTrainNumber(), getDepartureDate(), getDepartureTime(), getDestination(),
                getDepartureStation(), getDeparturePlatform(), getArrivalStation(), getTicketTypesAndCosts(), getArrivalDate(), getArrivalTime());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

    }

}