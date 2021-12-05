package com.example.tickets.controller;


import com.example.tickets.dto.EventCustomerSaleDTO;
import com.example.tickets.dto.EventDTO;
import com.example.tickets.dto.EventMapperDTO;
import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Event;
import com.example.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService service;
    @GetMapping()
 //   @GetMapping("/allEvent")
    public List<Event> findAllEvents() {
        return service.getEvent ();
    }

    @GetMapping("/allEvent")
    public List<Event> findAllSortedEvents() { return service.getSortedEvent();
    }
    @GetMapping("/allEventDTO")
    public List<EventDTO> getAllEventDTO() { return service.getAllEvent();
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

}
