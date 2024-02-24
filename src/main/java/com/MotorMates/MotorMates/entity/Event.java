package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Event {

    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "event_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    private String location;
    private int visitors;
    private String eventDate;

    public Event() {

    }

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
