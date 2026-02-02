package com.expensetracker;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    public static final String DATA_FILE = "expenses.csv";

    public void addExpense(Expense expense) { expenses.add(expense); }

    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\n(No expenses recorded yet.)");
            return;
        }
        System.out.println("\n--- ALL EXPENSES ---");
        System.out.println("| Date       | Amount     | Category        | Description");
        System.out.println("|------------|------------|-----------------|------------------");
        for (Expense e : expenses) System.out.println(e.toString());
    }

    public void generateCategoryReport() {
        Map<String, Double> totals = new HashMap<>();
        for (Expense e : expenses) {
            totals.put(e.getCategory(), totals.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        System.out.println("\n--- BY CATEGORY ---");
        totals.forEach((k, v) -> System.out.printf("%-15s: $%.2f%n", k, v));
    }

    public void generateMonthlyReport() {
        Map<Month, Double> totals = new HashMap<>();
        for (Expense e : expenses) {
            Month m = e.getDate().getMonth();
            totals.put(m, totals.getOrDefault(m, 0.0) + e.getAmount());
        }
        System.out.println("\n--- BY MONTH ---");
        totals.forEach((k, v) -> System.out.printf("%-15s: $%.2f%n", k, v));
    }

    public void saveExpenses() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            writer.println("Date,Amount,Category,Description");
            for (Expense e : expenses) writer.println(e.toCSV());
            System.out.println("Saved successfully.");
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    public void loadExpenses() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;
        expenses.clear();
        try (Scanner sc = new Scanner(file)) {
            if (sc.hasNextLine()) sc.nextLine(); // skip header
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",", 4);
                if (p.length == 4) {
                    expenses.add(new Expense(LocalDate.parse(p[0]), Double.parseDouble(p[1]), p[2], p[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}
