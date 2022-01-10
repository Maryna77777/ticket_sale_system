package com.example.tickets.controller;


import com.example.tickets.entity.Sale;
import com.example.tickets.security.CurrentUser;
import com.example.tickets.security.jwt.JwtUser;
import com.example.tickets.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Validated
@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService service;

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping("/customer/{customerId}")
    public List<Sale> getSaleByCustomer (@PathVariable(value = "customerId") Long customerId){
        return service.getAllSalesByCustomerId(customerId);
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping("/event/{eventId}")
    public List<Sale> getSaleByEvent (@PathVariable(value = "eventId") Long eventId){
        return service.getAllSalesByEventId(eventId);
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/user/event/{eventId}")
    public List<Sale> getSaleByEvent (@CurrentUser JwtUser user,
                                      @PathVariable(value = "eventId") Long eventId){
        return service.getAllSalesByEventId(eventId);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/customer/{customerId}/{eventId}")
    public Sale createSales2 (@PathVariable (value = "customerId") Long customerId,
                              @PathVariable (value = "eventId") Long eventId,
                              @Valid @RequestBody Sale sale) {
        return service.createSaleByCustomerIdAndEventId (customerId, eventId, sale);
    }

    @Secured({"ROLE_USER"})
    @PostMapping("/event/{eventId}")
    public Sale createSales5 (@CurrentUser JwtUser user,
                              @PathVariable (value = "eventId") Long eventId,
                              @Valid @RequestBody Sale sale) {

        return service.createSaleByUserIdAndEventId (user.getId(), eventId, sale);
    }

}
