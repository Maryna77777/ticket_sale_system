package com.example.tickets.service;

import com.example.tickets.MapperUtil;
import com.example.tickets.dto.EventDTO;
import com.example.tickets.dto.EventWithCustomerWithSaleDTO;
import com.example.tickets.dto.EventWithSaleDTO;
import com.example.tickets.dto.SaleDTO;
import com.example.tickets.entity.Event;
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

    private EventDTO convertToEventDTO(Event event) {
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        return eventDTO;
    }

    private EventWithCustomerWithSaleDTO convertToEventWithCustomerWithSaleDTO(Event event){
        EventWithCustomerWithSaleDTO eventWithCustomerWithSaleDTO = modelMapper.map(event, EventWithCustomerWithSaleDTO.class);
        return eventWithCustomerWithSaleDTO;
    }

    private EventWithSaleDTO convertToEventWithSaleDTO(Event event) {
        EventWithSaleDTO eventWithSaleDTO = modelMapper.map(event, EventWithSaleDTO.class);
        return eventWithSaleDTO;
    }

    public List<EventDTO> getEvent() {
        return MapperUtil.convertList(eventRepository.findAll(), this::convertToEventDTO);
    }

    public List<EventDTO> getEventLastName(String lastName){
        return MapperUtil.convertList(eventRepository.findByLastName (lastName),  this::convertToEventDTO);
    }

    public List<EventDTO> getSortedEvent(){
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

    public EventDTO getByTitle(String title) {
        return convertToEventDTO(eventRepository.findByTitle(title));
    }

    public List<EventWithCustomerWithSaleDTO> getAllEventWithCustomerWithSaleDTO() {
        return  MapperUtil.convertList(eventRepository.findAll(), this::convertToEventWithCustomerWithSaleDTO);
    }

    public List<EventWithSaleDTO> getEventWithSalesByCustomer(Long id) {
        return MapperUtil.convertList(eventRepository.findByCustomerId(id), this::convertToEventWithSaleDTO);
    }

}
