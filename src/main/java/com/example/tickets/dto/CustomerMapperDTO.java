package com.example.tickets.dto;

import com.example.tickets.entity.Event;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


@Getter
@Setter
public class CustomerMapperDTO {
    private String firstName;
    private String lastName;
    private List <Event> eventList;
}



