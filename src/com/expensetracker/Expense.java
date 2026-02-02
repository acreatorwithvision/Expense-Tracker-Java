package com.expensetracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private LocalDate date;
    private double amount;
    private String category;
    private String description;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Expense(LocalDate date, double amount, String category, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("| %s | %-10.2f | %-15s | %s", 
            date.format(DATE_FORMATTER), amount, category, description);
    }

    public String toCSV() {
        return String.format("%s,%.2f,%s,%s", 
            date.format(DATE_FORMATTER), amount, category, description.replaceAll(",", ";"));
    }
}
