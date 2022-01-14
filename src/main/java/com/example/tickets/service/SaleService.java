package com.example.tickets.service;


import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.repository.CustomerRepository;
import com.example.tickets.repository.EventRepository;
import com.example.tickets.repository.SaleRepository;
import com.example.tickets.security.repositorySecurity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EventRepository eventRepository;


    public List<Sale> getAllSalesByCustomerId(Long customerId) {
        return saleRepository.findByCustomerId(customerId);
    }

    public List<Sale> getAllSalesByEventId(Long eventId) {
        return saleRepository.findByEventId(eventId);
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

    public Sale createSaleByCustomerIdAndEventId(Long customerId, Long eventId, Sale sale) {
        Optional<Event> event =eventRepository.findById(eventId);
        Sale sale1 = new Sale();
        sale1.setId(sale1.getId());
        sale1.setNumber(sale.getNumber());
        sale1.setCost(event.get().getPrice()*sale.getNumber());

        sale1.setCustomer(customerRepository.findById(customerId).get());
        sale1.setEvent(eventRepository.findById(eventId).get());
        return saleRepository.save(sale1);
    }


    public Sale createSaleByUserIdAndEventId(Long userId, Long eventId, Sale sale) {
        sale.setCustomer(customerRepository.findById(userId).get());
        sale.setEvent(eventRepository.findById(eventId).get());
        return saleRepository.save(sale);
    }


}










