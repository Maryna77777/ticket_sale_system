package com.example.tickets.dto;

import com.example.tickets.entity.Sale;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class CustomerWithSaleDTO  {
    private long id;
    private String firstName;
    private String lastName;
    private List<Sale> sales;
}
