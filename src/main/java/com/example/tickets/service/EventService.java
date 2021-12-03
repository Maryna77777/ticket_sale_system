package com.example.tickets.service;

import com.example.tickets.entity.Event;
import com.example.tickets.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    public List<Event> getEvent() {
        return eventRepository.findAll();
    }
    public List<Event> getEventLastName(String lastName){
        return eventRepository.findByLastName (lastName);
    }

    public List<Event> getSortedEvent(){
        return eventRepository.findAllOrderByData();
    }


    public Event getByTitle(String title) {
        return eventRepository.findByTitle(title);
    }
}
