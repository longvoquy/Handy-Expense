package algorithm;

import data.Expense;

import static controller.Library.expenseList;


public class Method implements SET<Expense> {


    public boolean createExpense(int id, String date, Double number, String content) {
        boolean check;
        Expense expense = new Expense(id, date, number, content);
        check = add(expense);
        return check;

    }

    @Override
    public boolean add(Expense expense) {
        return expenseList.add(expense);
    }


    @Override
    public Expense showHandy(Expense expense) {
        return null;
    }

    @Override
    public boolean delete(Expense expense) {
        return expenseList.remove(expense);
    }
//--------------------------------------------------------

}