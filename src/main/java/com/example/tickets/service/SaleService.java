package com.example.tickets.service;


import com.example.tickets.MapperUtil;
import com.example.tickets.dto.EventDTO;
import com.example.tickets.dto.SaleDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.example.tickets.repository.CustomerRepository;
import com.example.tickets.repository.EventRepository;
import com.example.tickets.repository.SaleRepository;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;

    private SaleDTO convertToSaletDTO(Sale sale) {
        SaleDTO saleDTO = modelMapper.map(sale, SaleDTO.class);
        return saleDTO;
    }

    public List<SaleDTO> getAllSalesByCustomersId(Long customerId) {
        return MapperUtil.convertList(saleRepository.findByCustomerId(customerId), this::convertToSaleDTO);
    }

    public List<Sale> getAllSalesByEventId(Long eventId) {
        return saleRepository.findByEventId(eventId);
    }

    private SaleDTO convertToSaleDTO(Sale sale) {
        SaleDTO saleDTO = modelMapper.map(sale, SaleDTO.class);
        return saleDTO;
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
        Sale newSale = new Sale();
        newSale.setId(sale.getId());
        newSale.setNumber(sale.getNumber());
        newSale.setCost(event.get().getPrice()*sale.getNumber());
        newSale.setCustomer(customerRepository.findById(customerId).get());
        newSale.setEvent(eventRepository.findById(eventId).get());
        return saleRepository.save(newSale);
    }

    public Sale createSaleByUserIdAndEventId(Long userId, Long eventId, Sale sale) {
        sale.setCustomer(customerRepository.findById(userId).get());
        sale.setEvent(eventRepository.findById(eventId).get());
        return saleRepository.save(sale);
    }

}










