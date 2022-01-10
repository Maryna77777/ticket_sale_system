package com.example.tickets.service;

import com.example.tickets.dto.SaleCustomerDTO;
import com.example.tickets.entity.Customer;
import com.example.tickets.repository.CustomerRepository;
import com.example.tickets.security.model.User;
import com.example.tickets.security.repositorySecurity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public UserRepository userRepository;

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

    public Customer saveCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }

    public Customer saveCustomerUser (Long userId, Customer customer) {
        User newUser = userRepository.findById(userId).orElse(null);
        customer.setId(newUser.getId());
        customer.setFirstName (newUser.getFirstName());
        customer.setLastName(newUser.getLastName());
        return  customerRepository.save(customer);
    }

    public List<Customer> saveCustomerList(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return "Customer removed !! " + id;
    }

    public Customer updateCustomer (Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        existingCustomer.setFirstName (customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        return  customerRepository.save(existingCustomer);
    }
}