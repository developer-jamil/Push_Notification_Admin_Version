package com.jamillabltd.pushnotificationadminversion.model;

public class NotificationData {
    private String title;
    private String message;

    //constructor
    public NotificationData(String title, String message) {
        this.title = title;
        this.message = message;
    }

    //getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}