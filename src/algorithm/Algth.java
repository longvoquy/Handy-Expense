package algorithm;

import controller.Library;
import data.Expense;

import java.util.ArrayList;
import java.util.Scanner;

import static controller.Library.expenseList;


public class Algth {

    private final Scanner scanner = new Scanner(System.in);
    private static Method md = new Method();
    Library lb = new Library();



    //--------------------------------------------------------
    public void addIn() {
        boolean check;
        int ID = lb.generateNextId(expenseList);
        String Date = lb.getValidDate(scanner);
        double number = lb.getValidAmount(scanner);
        String content = lb.getValidContent(scanner);
        check = md.createExpense(ID, Date, number, content);
        if (check) {
            System.out.println("Input new successfully");
        } else {
            System.err.println("Input new failed");
        }
    }

    //--------------------------------------------------------
    public void printExpenseHistory(ArrayList<Expense> expenseList) {
//        if (expenseList.isEmpty()) {
//            System.err.println("No change history available.");
//        } else {
//            System.out.println("---------Display all expenses------------");
//            System.out.printf("%-4s  %-10s  %-8s  %-12s%n", "ID", "Date", "Amount", "Content");
//            for (Expense handy : expenseList) {
//                System.out.printf("%-4s  %-10s  %-8s  %-12s%n", handy.getID(), handy.getDate(), handy.getNumber(), handy.getContent());
//            }
//            System.out.println();
//        }
        if (expenseList.isEmpty()) {
            System.err.println("No change history available.");
        } else {
            System.out.println("---------Display all expenses------------");
            System.out.printf("%-4s  %-10s  %-8s  %-12s%n", "ID", "Date", "Amount", "Content");
            double totalAmount = 0.0; // Initialize the totalAmount variable

            for (Expense handy : expenseList) {
                System.out.printf("%-4s  %-10s  %-8s  %-12s%n", handy.getID(), handy.getDate(), handy.getNumber(), handy.getContent());

                // Add the expense amount to the totalAmount
                totalAmount += handy.getNumber();
            }

            System.out.println();
            System.out.println("Total Amount: " + totalAmount); // Print the total amount
        }
    }

    //--------------------------------------------------------
    public void deletedExpense() {

        System.out.println("--------Delete an expense------");
        int ID = lb.checkInputId(scanner);
        Expense expenseDel = lb.getExpenseByCode(expenseList, ID);
        if (expenseDel != null) {
            boolean check = md.delete(expenseDel); // Call the delete method to remove the expense
            if (check) {
                System.out.println("Expense with ID " + ID + " deleted successfully.");
            } else {
                System.err.println("Delete an expense failed.");
            }
        } else {
            System.out.println("Delete an expense failed. Expense with ID " + ID + " does not exist.");
        }
    }

}

//--------------------------------------------------------

