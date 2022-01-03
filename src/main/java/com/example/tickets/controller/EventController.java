package com.example.tickets.controller;


import com.example.tickets.dto.EventCustomerSaleDTO;
import com.example.tickets.dto.EventDTO;
import com.example.tickets.dto.EventMapperDTO;
import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController

@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService service;

    @PermitAll
    @GetMapping()
 //   @GetMapping("/allEvent")
    public List<Event> findAllEvents() {
        return service.getEvent ();
    }

    @PermitAll
    @GetMapping("/allEvent")
    public List<Event> findAllSortedEvents() { return service.getSortedEvent();
    }

//    @GetMapping("/allEventDTO")
//    public List<EventDTO> getAllEventDTO() { return service.getAllEvent();
//    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/addEvent")
    public Event addEvent (@RequestBody Event event) {
        return service.saveEvent(event);}

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/addEvents")
    public List<Event> addEvents(@RequestBody @Valid List<Event> events) {
        return service.saveEventList(events);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/updateEvent")
    public Event updateEvent(@RequestBody Event event) {
        return service.updateEvent(event);
    }


    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return service.deleteEvent(id);
    }

//
//    @GetMapping("/all1")
//    public List<EventMapperDTO> getAllEvent2(){
//        return  service.getAllEvent1();
//    }

    @PermitAll
    @GetMapping("/eventByTitle/{title}")
    public Event findEventByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/eventByCustomer/{lastName}")
    public List<Event> findEventCustomer (@PathVariable String lastName){
        return service.getEventLastName(lastName);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/all3")
    public List<EventCustomerSaleDTO> findAllEventCustomersSale() {
        return service.getAllEventCustomerSaleDTO();
    }

//
//    @PostMapping("/{customerId}/events")
//    public Event createEventById (@PathVariable (value = "customerId") Long customerId,
//                              @Valid @RequestBody Event event) {
//        return service.createEventByCustomerId(customerId, event);
//    }

}
