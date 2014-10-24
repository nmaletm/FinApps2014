package com.inteam.estrellawallet.domain.entities;

/**
 * Created by Nestor on 24/10/2014.
 */
import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private int budget;
    private List<Expense> listOfExpenses;

    public Wallet(){
        budget = 0;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}