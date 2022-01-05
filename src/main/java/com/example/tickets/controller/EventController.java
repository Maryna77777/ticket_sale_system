package com.example.tickets.controller;


import com.example.tickets.dto.EventCustomerSaleDTO;
import com.example.tickets.dto.EventDTO;
import com.example.tickets.dto.EventMapperDTO;
import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.service.EventService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController

@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService service;



    @GetMapping()
    public List<Event> findAllEvents() {
        return service.getEvent ();
    }

    @GetMapping("/allEvent")
    public List<Event> findAllSortedEvents() { return service.getSortedEvent();
    }
    @GetMapping("/allEventDTO")
    public List<EventDTO> getAllEventDTO() { return service.getAllEvent();
    }

    @PostMapping("/addEvent")
    public Event addEvent (@Valid @RequestBody Event event) {
        return service.saveEvent(event);}

    @PostMapping("/addEvents")
    public List<Event> addEvents(@Valid @RequestBody List<Event> events) {
        return service.saveEventList(events);
    }

    @PutMapping("/updateEvent")
    public Event updateEvent(@Valid @RequestBody Event event) {
        return service.updateEvent(event);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return service.deleteEvent(id);
    }

    @GetMapping("/all1")
    public List<EventMapperDTO> getAllEvent2(){
        return  service.getAllEvent1();
    }

    @GetMapping("/eventByTitle/{title}")
    public Event findEventByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @GetMapping("/eventByCustomer/{lastName}")
    public List<Event> findEventCustomer (@PathVariable String lastName){
        return service.getEventLastName(lastName);
    }

    @GetMapping("/all3")
    public List<EventCustomerSaleDTO> findAllEventCustomersSale() {
        return service.getAllEventCustomerSaleDTO();
    }

    @PostMapping("/{customerId}/events")
    public Event createEventById (@PathVariable (value = "customerId") Long customerId,
                              @Valid @RequestBody Event event) {

        return service.createEventByCustomerId(customerId, event);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getFieldErrors().forEach(error ->
//                errors.put(error.getField(), error.getDefaultMessage()));
//
//        return errors;
//    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
