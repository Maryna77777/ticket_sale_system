package com.example.tickets.service;

import com.example.tickets.entity.Event;
import com.example.tickets.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    public List<Event> getEvent() {

        return eventRepository.findAll();
    }
    public Event getByTitle(String title) {
        return eventRepository.findByTitle(title);
    }
}
