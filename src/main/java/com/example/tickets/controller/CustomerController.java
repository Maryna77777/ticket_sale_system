package com.example.tickets.controller;


import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.service.CustomerService;
import com.example.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping("/allCustomers")
    public List<Customer> findAllCustomers() {
        return service.getCustomer ();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer (@RequestBody  @Valid Customer customer) {
        return service.saveCustomer(customer);}

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody @Valid List<Customer> customers) {
        return service.saveCustomerList(customers);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody @Valid Customer customer) {
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return service.deleteCustomer(id);
    }

    @GetMapping("/customerByTitle/{title}")
    public List<Customer> findCustomerEvent (@PathVariable String title){
        return service.getCustomerTitle(title);
    }

    @GetMapping("/all")
    public List<SaleCustomerDTO> findAllCustomersSale() {
        return service.getAllCustomerSale();
    }
}
