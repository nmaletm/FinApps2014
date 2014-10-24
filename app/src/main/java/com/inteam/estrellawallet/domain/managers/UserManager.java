package com.inteam.estrellawallet.domain.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.inteam.estrellawallet.domain.entities.Article;
import com.inteam.estrellawallet.domain.entities.Expense;
import com.inteam.estrellawallet.domain.entities.User;

import java.util.Date;


public class UserManager {
    private final String SHARED_PREF_KEY = "user_key";
    private final String SHARED_PREF = "shared";
    private SharedPreferences settings;

    public UserManager(Context context){
        this.settings = context.getSharedPreferences(SHARED_PREF, 0);
    }
    public User getUser(){
        return this.load();
    }


    public void setBudget(int budget){
        User user = this.load();
        user.getWallet().setBudget(budget);
        this.save(user);
    }

    public void addExpense(float amount, String category){
        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setDate(new Date());

        User user = this.load();
        user.getWallet().addExpenses(expense);
        this.save(user);
    }

    public boolean hasBudget(){
        User user = this.load();
        return user.getWallet().getBudget() != 0;
    }

    public void addDesiredArticle(Article article){
        User user = this.load();
        user.addDesiredArticle(article);
        this.save(user);
    }

    public void save(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        settings.edit().putString(SHARED_PREF_KEY, json);
    }

    public User load(){
        String jsonString = settings.getString(SHARED_PREF_KEY,null);
        if(jsonString == null){
            return new User();
        }
        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);
        return user;
    }
}
