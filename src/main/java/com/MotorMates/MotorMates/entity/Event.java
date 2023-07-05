package com.MotorMates.MotorMates.entity;

public class Event {

    private String place;
    private String visitors;
    private String date;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVisitors() {
        return visitors;
    }

    public void setVisitors(String visitors) {
        this.visitors = visitors;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Event(String place, String visitors, String date) {
        setPlace(place);
        setVisitors(visitors);
        setDate(date);
    }
}
