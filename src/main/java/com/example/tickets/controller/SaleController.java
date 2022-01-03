package com.example.tickets.controller;


import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.service.EventService;
import com.example.tickets.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService service;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/customer/{customerId}/sales")
    public List<Sale> getSaleByCustomer (@PathVariable(value = "customerId") Long customerId){
        return service.getAllSalesByCustomerId(customerId);
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/event/{eventId}/sales")
    public List<Sale> getSaleByEvent (@PathVariable(value = "eventId") Long eventId){
        return service.getAllSalesByEventId(eventId);
    }


//    @PostMapping("/{customerId}/sales")
//    public Sale createSales (@PathVariable (value = "customerId") Long customerId,
//                             @Valid @RequestBody Sale sale) {
//        return service.createSaleByCustomerId(customerId, sale);
//    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/{customerId}/{eventId}/sales")
    public Sale createSales2 (@PathVariable (value = "customerId") Long customerId,
                              @PathVariable (value = "eventId") Long eventId,
                              @Valid @RequestBody Sale sale) {
        return service.createSaleByCustomerIdAndEventId (customerId, eventId, sale);
    }

}
