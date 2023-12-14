package org.example.print;

import org.example.table.format.TableFormat;

public class TrainTablePrinter implements VehicleTablePrinter {
    @Override
    public void printTableHeader() {
        TableFormat tableFormat = TableFormat.getTableFormat();
        String format = tableFormat.getFormat();

        System.out.printf(format, "Train Number", "Departure Date", "Departure Time", "Destination", "Departure Station",
                "Departure Platform", "Arrival Station", "Ticket Types and Costs", "Arrival Date", "Arrival Time");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
}