package com.example.tickets.controller;


import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @GetMapping()
  //  @GetMapping("/allCustomers")
    public List<Customer> findAllCustomers() {
        return service.getCustomer ();
    }

    @GetMapping("/customerByTitle/{title}")
    public List<Customer> findCustomerEvent (@PathVariable String title){
        return service.getCustomerTitle(title);
    }

    @GetMapping("/allCustomersSale")
    public List<SaleCustomerDTO> findAllCustomersSale() {
        return service.getAllCustomerSale();
    }


}
