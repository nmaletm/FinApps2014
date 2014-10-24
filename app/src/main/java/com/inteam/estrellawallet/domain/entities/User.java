package com.inteam.estrellawallet.domain.entities;

/**
 * Created by Nestor on 24/10/2014.
 */
import java.util.ArrayList;
import java.util.List;

public class User {

    private Wallet wallet;
    private List<Article> desiredArticles;

    public User(){
        this.wallet = new Wallet();
        this.desiredArticles = new ArrayList<Article>();
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
}