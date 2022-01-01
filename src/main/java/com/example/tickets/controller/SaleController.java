package com.example.tickets.controller;


import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.service.EventService;
import com.example.tickets.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/customer/{customerId}/sales")
    public List<Sale> getSaleByCustomer (@PathVariable(value = "customerId") Long customerId){
        return service.getAllSalesByCustomerId(customerId);
    }

    @GetMapping("/event/{eventId}/sales")
    public List<Sale> getSaleByEvent (@PathVariable(value = "eventId") Long eventId){
        return service.getAllSalesByEventId(eventId);
    }

    @PostMapping("/customer/{customerId}/createsales")
    public Sale createSales (@PathVariable (value = "customerId") Long customerId,
                                       @Valid @RequestBody Sale sale) {
        return service.createSale(customerId, sale);
    }

    @PostMapping("/customer/{customerId}/create")
    public Sale createSales1 ( @PathVariable (value ="customerId") Long customerId,
                              @Valid @RequestBody Sale sale) {
        return service. createSale2(customerId, sale);
    }

    @PostMapping("/{customerId}/sales")
    public Sale createSales7 (@PathVariable (value = "customerId") Long customerId,
                             @Valid @RequestBody Sale sale) {
        return service.createSaleByCustomerId(customerId, sale);
    }

//    @PostMapping("/{customerId}/event/sales")
//    public void createSales7 (@PathVariable (value = "customerId") Long customerId,
//                              @Valid @RequestBody Event event,
//                              @Valid @RequestBody Sale sale) {
//        service.createSaleAndEventByCustomerId(customerId, event, sale);
//    }

//    @PostMapping("/customer/create")
//    public ResponseEntity<Customer> create1 (@Valid @RequestBody Customer customer) {
//        return service.create(customer);
//    }


//    @GetMapping("/event/{eventId}/{customerId}/sales")
//    public List<Sale> getSaleByEventCustomer (@PathVariable(value = "eventId") Long eventId,@PathVariable(value = "customerId") Long customerId){
//        return service.getSalesByEventIdCustomerId(eventId, customerId);
//    }
//
}
