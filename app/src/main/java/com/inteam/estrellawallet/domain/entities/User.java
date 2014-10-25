package com.inteam.estrellawallet.domain.entities;

/**
 * Created by Nestor on 24/10/2014.
 */
import java.util.ArrayList;
import java.util.List;

public class User {

    private Wallet wallet;
    private List<Article> desiredArticles;
    private int points;

    public User(){
        this.wallet = new Wallet();
        this.desiredArticles = new ArrayList<Article>();
        this.points = 0;
    }


    public int pointsEarned(int amount){
        return amount / 6;
    }

    public void addDesiredArticle(Article article){
        this.desiredArticles.add(article);
    }
    public List<Article> getDesiredArticles() {
        return desiredArticles;
    }

    public void setDesiredArticles(List<Article> desiredArticles) {
        this.desiredArticles = desiredArticles;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int getPoints() {
        return points;
    }

    public void incrementPoints(int points) {
        this.points += points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}