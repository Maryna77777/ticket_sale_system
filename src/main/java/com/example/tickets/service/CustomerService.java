package com.example.tickets.service;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.repository.CustomerRepository;
import com.example.tickets.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }


}
