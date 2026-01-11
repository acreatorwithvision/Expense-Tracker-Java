package com.expensetracker;

import java.util.ArrayList;
import java.util.List;

//Manages the collection of expense objects.
public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager(){
        this.expenses=new ArrayList<>();
    }

    // Add new expense
    public void addExpense(Expense expense){
        if(expense!=null){
            this.expenses.add(expense);
        }
    }

    //Return expenses
    public List<Expense> getExpense(){
        return new ArrayList<>(expenses);
    }

    public void viewAllExpenses(){
        if(expenses.isEmpty()){
            System.out.println("\n(No expenses recorded yet.");
            return;
        }

        System.out.println("\n--- ALL EXPENSES ---");
        System.out.println("| Date     | Amount     | Category      | Description");
        System.out.println("|----------|------------|---------------|------------------");

        for(Expense expense:expenses){
            System.out.println(expense.toString());
        }
        System.out.println("-----------------------------------------------------------------");
    }

}
