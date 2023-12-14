package org.example.table.format;


import lombok.Getter;

@Getter
public class TableFormat {

    private final String format;
    private static volatile TableFormat instance;

    private TableFormat() {
        format = "%-12s | %-15s | %-14s | %-11s | %-18s | %-18s | %-17s | %-11s | %-21s | %-11s%n";
    }

    public static TableFormat getTableFormat() {
        if (instance == null) {
            synchronized (TableFormat.class) {
                if (instance == null) {
                    instance = new TableFormat();
                }
            }
        }
        return instance;
    }

}