package com.inteam.estrellawallet.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wallet {

    private int budget;
    private List<Expense> listOfExpenses;

    public Wallet(){
        budget = 0;
        listOfExpenses = new ArrayList<Expense>();
    }

    public List<Expense> getListOfExpenses() {
        return listOfExpenses;
    }

    public void addExpenses(Expense expense) {
        this.listOfExpenses.add(expense);
    }

    public void setListOfExpenses(List<Expense> listOfExpenses) {
        this.listOfExpenses = listOfExpenses;
    }

    public int getSpentSinceDate(Date date){
        int spent = 0;
        for (Expense expense : listOfExpenses) {
           if(date.compareTo(expense.getDate()) < 0){
               spent += expense.getAmount();
           }
        }
        return spent;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}