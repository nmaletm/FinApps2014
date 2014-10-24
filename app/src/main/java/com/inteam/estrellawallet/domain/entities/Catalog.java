package com.inteam.estrellawallet.domain.entities;

/**
 * Created by Nestor on 24/10/2014.
 */
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Article> listOfArticles;

    public Catalog(){
        listOfArticles = new ArrayList<Article>();
    }
    public List<Article> getListOfArticles() {
        return listOfArticles;
    }

    public void setListOfArticles(List<Article> listOfArticles) {
        this.listOfArticles = listOfArticles;
    }

    public void addArticle(Article articles) {
        listOfArticles.add(articles);
    }
}