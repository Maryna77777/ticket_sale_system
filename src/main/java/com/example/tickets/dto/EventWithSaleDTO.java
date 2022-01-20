package com.example.tickets.dto;

import com.example.tickets.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventWithSaleDTO {
    private long id;
    private String title;
    private List<Sale> sales;
}
