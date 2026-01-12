package com.expensetracker;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class ExpenseTrackerApp{

	private ExpenseManager manager;
	private Scanner scanner;

	public ExpenseTrackerApp(){
		this.manager= new ExpenseManager();
		this.scanner=new Scanner(Scanner.in);
	}

	public void run(){
		System.out.println("--- Simple Console-Bases Expense Tracker ---");

		boolean running=true;
		while(running){
			printMenu();
			String choice=scanner.nextLine().trim();

			switch(choice){
				case "1":
					addExpense();
					break;
				case "2":
					manager.viewAllExpenses();
					break;
				case "3":
					System.out.println("\nReporting feature coming soon!");
					break;

				case "4":
					//Save/load will go here
					System.out.println("\nSaving/Loading feature coming soon");
					break;
				case "5":
					running=false;
					System.out.println("Exiting application. Goodbye");
					break;
				default:
					System.out.println("Invalid choice. Please select an option from 1 to 5");
			}
		}
		scanner.close();
	}
	private void printMenu(){
		System.out.println("\n[MENU");
		System.out.println("1. Add New Expenses");
		System.out.println("2. View All Expenses");
		System.out.println("3. Generate Reports (Coming Soon)");
		System.out.println("4. Save/Load Data (Coming Soon)");
		System.out.println("5. Exit");
		System.out.println("Enter your choice: ");
	}

	private void addExpenses(){
		System.out.println("\n--- ADD NEW EXPENSE ---");
		LocalDate date=null;
		double amount=-1;

		//1. Get Date
		while(date==null){
			System.out.println("Enter Date (YYYY-MM-DD): ");
			String dateString=scanner.nextLine();
			try{
				date=LocalDate.parse(dateString);
			}catch (DateTimeParseExceptionn e){
				System.out.println("Invalid date format. Please use YYYY-MM-DD.");
			}
		}

		//2. Get Amount
		while(amount<0){
			System.out.println("Enter Amount: ");
			try{
				amount=Double.parseDouble(scanner.nextLine());
				if(amount<=0){
					System.out.println("Amount must be a positive number.");
					amount=amount-1; //reset for loop
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid amount. Please enter a number");
			}
		}
	}
	
}
