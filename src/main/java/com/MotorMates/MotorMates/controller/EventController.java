package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.Event;
import com.MotorMates.MotorMates.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvent() {
        return eventService.getEvent();
    }

    @PostMapping("/create")
    public void newEvent(@RequestBody Event event) {
        eventService.addNewEvent(event);
    }
}
