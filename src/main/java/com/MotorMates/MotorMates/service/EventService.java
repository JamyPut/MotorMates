package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.Event;
import com.MotorMates.MotorMates.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvent() {
        return eventRepository.findAll();
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }
}
