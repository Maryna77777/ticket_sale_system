package com.example.tickets.controller;


import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.service.CustomerService;
import com.example.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Secured("ROLE_MANAGER")
    @GetMapping()
    public List<Customer> findAllCustomers() {
        return service.getCustomer ();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping()
    public Customer addCustomer (@Valid @RequestBody Customer customer) {
        return service.saveCustomer(customer);}

    @Secured("ROLE_ADMIN")
    @PostMapping("/list")
    public List<Customer> addCustomers(@RequestBody @Valid List<Customer> customers) {
        return service.saveCustomerList(customers);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping()
    public Customer updateCustomer(@RequestBody @Valid  Customer customer) {
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public Customer deleteCustomer1(@PathVariable Long id) {
        return service.deleteCustomer1(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return service.deleteCustomer(id);
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/ByEvent/{title}")
    public List<Customer> findCustomerEvent (@PathVariable  String title){
        return service.getCustomerTitle(title);
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/allSales")
    public List<SaleCustomerDTO> findAllCustomersSale() {
        return service.getAllCustomerSale();
    }

}
