package com.example.tickets.controller;


import com.example.tickets.dto.CustomerEventDTO;
import com.example.tickets.dto.CustomerMapperDTO;
import com.example.tickets.dto.CustomerSaleDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping()
    public List<CustomerMapperDTO> findAllCustomers() {
        return service.getCustomer ();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping()
    public Customer addCustomer (@Valid @RequestBody Customer customer) {
        return service.saveCustomer(customer);}

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/user/{userId}")
    public Customer addCustomerByUserId (@PathVariable (value = "userId") Long userId,
                                          @RequestBody Customer customer) {
        return service.saveCustomerUser (userId, customer);}

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

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return service.deleteCustomer(id);
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/ByEvent/{title}")
    public List<CustomerMapperDTO> findCustomerEventByTitle (@PathVariable  String title){
        return service.getCustomerEventByTitle(title);
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/allSales")
    public List<CustomerSaleDTO> findAllCustomersSales() {
        return service.getAllCustomerSale();
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/allCustomersEvents")
    public List<CustomerEventDTO> findAllCustomersEvents() { return service.getAllCustomersEvents();}

}
