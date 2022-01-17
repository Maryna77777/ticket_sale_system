package com.example.tickets.service;

import com.example.tickets.MapperUtil;
import com.example.tickets.dto.CustomerDTO;
import com.example.tickets.dto.CustomerWithEventDTO;
import com.example.tickets.dto.CustomerWithSaleDTO;
import com.example.tickets.entity.Customer;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;

    private CustomerDTO convertToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;}

    private CustomerWithSaleDTO convertToCustomerWithSaleDTO(Customer customer) {
        CustomerWithSaleDTO customerWithSaleDTO = modelMapper.map(customer, CustomerWithSaleDTO.class);
        return customerWithSaleDTO ;}

    private CustomerWithEventDTO convertToCustomerWithEventDTO(Customer customer) {
        CustomerWithEventDTO customerWithEventDTO = modelMapper.map(customer, CustomerWithEventDTO.class);
        return customerWithEventDTO ;}


    public List<CustomerDTO> getCustomer() {
        return MapperUtil.convertList(customerRepository.findAll(), this:: convertToCustomerDTO);
    }

    public List<CustomerDTO> getCustomerEventByTitle(String title) {
        return MapperUtil.convertList(customerRepository.findByTitle(title), this:: convertToCustomerDTO);
    }

    public List<CustomerWithSaleDTO> getAllCustomerWithSale() {
        return  MapperUtil.convertList(customerRepository.findAll(), this::convertToCustomerWithSaleDTO);
    }

    public List<CustomerWithEventDTO> getAllCustomersWithEvents(){
        return  MapperUtil.convertList(customerRepository.findAll(), this::convertToCustomerWithEventDTO);
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