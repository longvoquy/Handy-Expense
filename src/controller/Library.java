package controller;

import data.Expense;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;


public class Library {
    public static ArrayList<Expense> expenseList = new ArrayList<>();


    //-------------------------------------------------------------------------------
    // Phương thức tự động tăng ID
    public int generateNextId(ArrayList<Expense> lc) {
        int lastId = 0;
        for (Expense handy : lc) {
            if (handy.getID() > lastId) {
                lastId = handy.getID();
            }
        }
        return lastId + 1;
    }


    //--------------------------------------------------------
    public String getValidContent(Scanner scanner) {
        String content;
        do {
            content = getInput("Enter Content: ", scanner, s -> !s.isEmpty(), "Content cannot be empty");
        } while (content.isEmpty());
        return content;

    }

    //--------------------------------------------------------
    public String getValidDate(Scanner scanner) {
        String date;
        do {
            date = getInput("Enter Date: ", scanner, s -> s.matches("\\\\d{2}-[A-Z][a-z]{2}-\\\\d{4}") || !s.isEmpty(), "Invalid Date format");
        } while (date.isEmpty());
        return date;
    }

    //--------------------------------------------------------
    public double getValidAmount(Scanner scanner) {
        double amount;
        do {
            String amountInput = getInput("Enter Amount: ", scanner, s -> s.matches("\\d+(\\.\\d+)?") && Double.parseDouble(s) > 0, "Invalid Amount (must be a positive number)");
            amount = Double.parseDouble(amountInput);
        } while (amount <= 0);
        return amount;

    }

    //--------------------------------------------------------
    public Expense getExpenseByCode(ArrayList<Expense> wIDList, int id) {
        for (Expense worker : wIDList) {
            if (id == worker.getID()) {
                return worker;
            }
        }
        return null;
    }


    public int checkInputId(Scanner scanner) {
        int id = 0; // Initialize id as 0
        boolean isValid = false;
        do {
            String input = getInput("Enter ID:", scanner, s -> !s.isEmpty(), "ID cannot be empty");
            try {
                id = Integer.parseInt(input); // Parse the input as an integer
                isValid = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer ID.");
            }
        } while (!isValid);
        return id;
    }

    //--------------------------------------------------------
    public String getInput(String prompt, Scanner scanner, Predicate<String> validator, String errorMessage) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (!validator.test(input)) {

                System.err.println(errorMessage);
            }
        } while (!validator.test(input));
        return input;
    }
    //--------------------------------------------------------
}
