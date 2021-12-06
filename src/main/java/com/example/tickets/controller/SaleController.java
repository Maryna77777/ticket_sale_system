package com.example.tickets.controller;


import com.example.tickets.entity.Sale;
import com.example.tickets.service.EventService;
import com.example.tickets.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping("/customer/{customerId}/sales")
    public List<Sale> getSaleByCustomer (@PathVariable(value = "customerId") Long customerId){
        return service.getAllSalesByCustomerId(customerId);
    }

    @GetMapping("/event/{eventId}/sales")
    public List<Sale> getSaleByEvent (@PathVariable(value = "eventId") Long eventId){
        return service.getAllSalesByEventId(eventId);
    }
//    @GetMapping("/event/{eventId}/{customerId}/sales")
//    public List<Sale> getSaleByEventCustomer (@PathVariable(value = "eventId") Long eventId,@PathVariable(value = "customerId") Long customerId){
//        return service.getSalesByEventIdCustomerId(eventId, customerId);
//    }
//
}
