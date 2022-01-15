package com.example.tickets.service;

import com.example.tickets.MapperUtil;
import com.example.tickets.dto.EventCustomerSaleDTO;
import com.example.tickets.dto.EventMapperDTO;
import com.example.tickets.entity.Event;
import com.example.tickets.mapper.EventMapper;
import com.example.tickets.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ModelMapper modelMapper;

    private EventMapperDTO convertToEventDTO(Event event) {
        EventMapperDTO eventMapperDTO = modelMapper.map(event, EventMapperDTO.class);
        return eventMapperDTO;
    }

    private EventCustomerSaleDTO convertToEventCustomerSaleDTO(Event event){
        EventCustomerSaleDTO eventCustomerSaleDTO = modelMapper.map(event, EventCustomerSaleDTO.class);
        return eventCustomerSaleDTO;
    }

    public List<EventMapperDTO> getEvent() {
        return MapperUtil.convertList(eventRepository.findAll(), this::convertToEventDTO);
    }

    public List<EventMapperDTO> getEventLastName(String lastName){
        return MapperUtil.convertList(eventRepository.findByLastName (lastName),  this::convertToEventDTO);
    }

    public List<EventMapperDTO> getSortedEvent(){
        return MapperUtil.convertList(eventRepository.findAllOrderByData(),  this::convertToEventDTO);}

    public Event saveEvent(Event event) {
        return  eventRepository.save(event);
    }

    public List<Event> saveEventList(List<Event> event) {
        return eventRepository.saveAll(event);
    }

    public String deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return "event removed !! " + id;
    }

        public Event updateEvent (Event event ) {
        Event existingEvent = eventRepository.findById(event.getId()).orElse(null);
        existingEvent.setTitle (event.getTitle());
        existingEvent.setData(event.getData());
        existingEvent.setPrice(event.getPrice());
        return  eventRepository.save(existingEvent);
    }

    public EventMapperDTO getByTitle(String title) {
        return convertToEventDTO(eventRepository.findByTitle(title));
    }

    public List<EventCustomerSaleDTO> getAllEventCustomerSaleDTO() {
        return  MapperUtil.convertList(eventRepository.findAll(), this::convertToEventCustomerSaleDTO);
    }
}
