package com.example.tickets.dto;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@EnableTransactionManagement
@Getter
@Setter
public class EventWithCustomerWithSaleDTO {
    private long id;
    private String title;
    private List<Customer> customers;
    private List<Sale> sales;
}


