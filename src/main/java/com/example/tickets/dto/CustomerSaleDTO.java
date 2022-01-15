package com.example.tickets.dto;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class CustomerSaleDTO  {
    private long id;
    private String firstName;
    private String lastName;
    private List<Sale> sales;
}
