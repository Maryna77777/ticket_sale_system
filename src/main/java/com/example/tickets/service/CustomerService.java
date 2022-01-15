package com.example.tickets.service;

import com.example.tickets.MapperUtil;
import com.example.tickets.dto.CustomerEventDTO;
import com.example.tickets.dto.CustomerMapperDTO;
import com.example.tickets.dto.CustomerSaleDTO;
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

    private CustomerMapperDTO convertToCustomerDTO(Customer customer) {
        CustomerMapperDTO customerMapperDTO = modelMapper.map(customer, CustomerMapperDTO.class);
        return customerMapperDTO;}

    private CustomerSaleDTO convertToCustomerSaleDTO(Customer customer) {
        CustomerSaleDTO customerSaleDTO = modelMapper.map(customer, CustomerSaleDTO.class);
        return customerSaleDTO ;}

    private CustomerEventDTO convertToCustomerEventDTO(Customer customer) {
        CustomerEventDTO customerEventDTO = modelMapper.map(customer, CustomerEventDTO.class);
        return customerEventDTO ;}


    public List<CustomerMapperDTO> getCustomer() {
        return MapperUtil.convertList(customerRepository.findAll(), this:: convertToCustomerDTO);
    }

    public List<CustomerMapperDTO> getCustomerEventByTitle(String title) {
        return MapperUtil.convertList(customerRepository.findByTitle(title),this:: convertToCustomerDTO);
    }

    public List<CustomerSaleDTO> getAllCustomerSale() {
        return  MapperUtil.convertList(customerRepository.findAll(), this::convertToCustomerSaleDTO);
    }

    public List<CustomerEventDTO> getAllCustomersEvents(){
        return  MapperUtil.convertList(customerRepository.findAll(), this::convertToCustomerEventDTO);
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