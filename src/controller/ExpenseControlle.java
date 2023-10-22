package controller;

import algorithm.Algth;
import view.Menu;

import static controller.Library.expenseList;


public class ExpenseControlle extends Menu<String> {


    Algth md = new Algth();


    //--------------------------------------------------------
    static String[] menu = {"Add an expense", "Display all expenses", "Delete an expense", "EXIT (0)"};

    public ExpenseControlle() {
        super("\n----------!!Control System!!----------", menu);

    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> addExpense();
            case 2 -> printlistExpense();
            case 3 -> deleteExpense();

        }
    }

    //--------------------------------------------------------
    private void deleteExpense() {
        md.deletedExpense();
    }

    //--------------------------------------------------------
    public void printlistExpense() {
        // Gọi phương thức để in ra lịch sử
        md.printExpenseHistory(expenseList);
    }


    //--------------------------------------------------------
    private void addExpense() {
        md.addIn();
    }
//--------------------------------------------------------

}
