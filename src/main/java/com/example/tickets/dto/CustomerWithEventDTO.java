package com.example.tickets.dto;

import com.example.tickets.entity.Event;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class CustomerWithEventDTO {
    private long id;
    private String firstName;
    private String lastName;
    private List<Event> events;
}