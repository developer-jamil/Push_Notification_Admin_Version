package com.jamillabltd.pushnotificationadminversion.model;

public class PushNotification {

    private NotificationData data;
    private String to;

    //constructor
    public PushNotification(NotificationData data, String to) {
        this.data = data;
        this.to = to;
    }


    //getter and setter
    public NotificationData getData() {
        return data;
    }

    public void setData(NotificationData data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }



}