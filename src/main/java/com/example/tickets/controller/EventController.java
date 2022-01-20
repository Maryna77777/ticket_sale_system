package com.example.tickets.controller;


import com.example.tickets.dto.EventDTO;
import com.example.tickets.dto.EventWithCustomerWithSaleDTO;
import com.example.tickets.dto.EventWithSaleDTO;
import com.example.tickets.entity.Event;
import com.example.tickets.security.CurrentUser;
import com.example.tickets.security.jwt.JwtUser;
import com.example.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService service;

    @PermitAll
    @GetMapping()
    public List<EventDTO> findAllEvents() {
        return service.getEvent ();
    }

    @PermitAll
    @GetMapping("/sorted")
    public List<EventDTO> findAllSortedEvents() { return service.getSortedEvent();
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @PostMapping()
    public Event addEvent (@Valid @RequestBody Event event) {
        return service.saveEvent(event);}

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @PostMapping("/list")
    public List<Event> addEvents(@RequestBody @Valid List<Event> events) {
        return service.saveEventList(events);
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @PutMapping()
    public Event updateEvent(@Valid @RequestBody Event event) {
        return service.updateEvent(event);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return service.deleteEvent(id);
    }

    @PermitAll
    @GetMapping("/ByTitle/{title}")
    public EventDTO findEventByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping("/eventByCustomer/{lastName}")
    public List<EventDTO> findEventCustomer (@PathVariable String lastName){
        return service.getEventLastName(lastName);
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping("/all")
    public List<EventWithCustomerWithSaleDTO> findAllEventCustomersSale() {
        return service.getAllEventWithCustomerWithSaleDTO();
    }

    @GetMapping("/sale/customer")
    public List<EventWithSaleDTO> findEventWithSaleByCurrentCustomer (@CurrentUser JwtUser user) {
        return service.getEventWithSalesByCustomer(user.getId());
    }

}
