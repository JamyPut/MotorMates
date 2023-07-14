package com.MotorMates.MotorMates.entity;

public class Event {

    private String location;
    private int visitors;
    private String eventDate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Event(String location, int visitors, String eventDate) {
        setLocation(location);
        setVisitors(visitors);
        setEventDate(eventDate);
    }
}
