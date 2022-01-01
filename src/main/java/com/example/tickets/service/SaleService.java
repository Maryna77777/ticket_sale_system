package com.example.tickets.service;


import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.repository.CustomerRepository;
import com.example.tickets.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerRepository eventRepository;

    public List<Sale> getAllSalesByCustomerId(Long customerId) {
        return saleRepository.findByCustomerId(customerId);
    }

    public List<Sale> getAllSalesByEventId(Long eventId) {
        return saleRepository.findByEventId(eventId);
    }

    public Sale createSale(Long customerId, Sale sale) {
        return saleRepository.findById(customerId).map(customer -> {
            Customer customer1 = new Customer();
            sale.setCustomer(customer1);
            return saleRepository.save(sale);
        }).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
    }

    public Sale createSale2(Long customerId, Sale sale) {
        return saleRepository.findById(customerId).map(customer -> {
            Sale newSale = new Sale();
            newSale.setNumber(sale.getNumber());
            newSale.setCost(sale.getCost());
            newSale.setCustomer(sale.getCustomer());
            return saleRepository.save(newSale);
        }).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found"));
    }


    public ResponseEntity<Customer> create(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCustomer.getId()).toUri();
        return ResponseEntity.created(location).body(savedCustomer);
    }


    public Sale createSaleByCustomerId(Long customerId, Sale sale) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer != null) {
            List<Sale> sales = customer.get().getSales();
            sales.add(sale);
            customer.get().setSales(sales);
            sale.setCustomer(customer.get());
        }
        return saleRepository.save(sale);
    }



//    public void createSaleAndEventByCustomerId(Long customerId, Event event, Sale sale) {
//        Optional<Customer> customer = customerRepository.findById(customerId);
//        if (customer != null) {
//            List<Event> events = customer.get().getEvents();
//            events.add(event);
//            customer.get().setEvents(events);
//            event.setCustomer(customer.get());
//
//            List<Sale> sales = customer.get().getSales();
//            sales.add(sale);
//            customer.get().setSales(sales);
//            sale.setCustomer(customer.get());
//        }
//        saleRepository.saveAll(event, sale);
//    }
}










