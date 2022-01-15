package com.example.tickets.dto;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Sale;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventMapperDTO {
    private long id;
    private String title;
    private Date data;
    private int price;
    private int available;
    }


