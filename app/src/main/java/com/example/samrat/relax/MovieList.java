package com.example.samrat.relax;

public class MovieList {
    String name,date,poster,language,plot;
    int popularity;
    double rating;

    public MovieList(String name, String date,int popularity,String poster,String language,double rating,String plot) {
        this.name = name;
        this.date = date;
        this.popularity = popularity;
        this.poster=poster;
        this.language = language;
        this.rating = rating;
        this.plot = plot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
