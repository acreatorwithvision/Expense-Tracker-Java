package com.expensetracker;

import java.util.Scanner;
import java.time.LocalDate;

public class ExpenseTrackerApp {
    private ExpenseManager manager = new ExpenseManager();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        manager.loadExpenses();
        while (true) {
            System.out.println("\n1. Add | 2. View | 3. Reports | 4. Save | 5. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) addExpense();
            else if (choice.equals("2")) manager.viewAllExpenses();
            else if (choice.equals("3")) showReports();
            else if (choice.equals("4")) manager.saveExpenses();
            else if (choice.equals("5")) break;
        }
    }

    private void addExpense() {
        try {
            System.out.print("Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());
            System.out.print("Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            System.out.print("Category: ");
            String cat = scanner.nextLine();
            System.out.print("Description: ");
            String desc = scanner.nextLine();
            manager.addExpense(new Expense(date, amount, cat, desc));
        } catch (Exception e) {
            System.out.println(" Invalid Input!");
        }
    }

    private void showReports() {
        System.out.print("Report: (C)ategory or (M)onth? ");
        String r = scanner.nextLine().toUpperCase();
        if (r.equals("C")) manager.generateCategoryReport();
        else if (r.equals("M")) manager.generateMonthlyReport();
    }

    public static void main(String[] args) {
        new ExpenseTrackerApp().run();
    }
}
