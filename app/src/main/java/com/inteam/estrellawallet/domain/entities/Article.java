package com.inteam.estrellawallet.domain.entities;

public class Article {
    private String name;
    private int points;
    private String urlPhoto;

    public Article(String name, int points, String urlPhoto){
        this.name = name;
        this.points = points;
        this.urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public String getUrlPhoto() { return urlPhoto; }

}
