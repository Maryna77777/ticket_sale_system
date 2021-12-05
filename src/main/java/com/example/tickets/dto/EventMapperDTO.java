package com.example.tickets.dto;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Sale;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;
@Getter
@Setter
public class EventMapperDTO {
    private long id;
    private String title;
    private List<Customer> customerList;
    private List<Sale> saleList;
    }


