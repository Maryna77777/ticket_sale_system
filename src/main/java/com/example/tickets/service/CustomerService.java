package com.example.tickets.service;

import com.example.tickets.dto.SaleCustomerDTO;
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

    public List<Customer> getCustomerTitle(String title) {
        return customerRepository.findByTitle(title);
    }

    public List<SaleCustomerDTO> getAllCustomerSale() {
        SaleCustomerDTO saleCustomerDTO = new SaleCustomerDTO();
        return saleCustomerDTO.getSaleCustomerDTOList(customerRepository.findAll());
    }


    



//    public List<SaleCustomerDTO> getSaleByTitle(String title) {
//        SaleCustomerDTO saleCustomerDTO = new SaleCustomerDTO();
//        return saleCustomerDTO.getSaleCustomerDTOList(customerRepository.findSaleByTitle(title));
//    }


}