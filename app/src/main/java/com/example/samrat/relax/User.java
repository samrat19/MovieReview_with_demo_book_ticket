package com.example.samrat.relax;

public class User {
    String username,id,contact,ticket,moviename;

    public User(String username,String id, String contact, String ticekt,String moviename) {
        this.username = username;
        this.id=id;
        this.contact = contact;
        this.ticket = ticekt;
        this.moviename = moviename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicekt(String ticket) {
        this.ticket = ticket;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
}
