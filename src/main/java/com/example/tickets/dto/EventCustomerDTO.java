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
public class EventCustomerDTO {
    private long id;
    private String firstName;
    private String lastName;
    private List<Event> eventsList;


    @Transactional
    public List<EventCustomerDTO> getEventCustomerDTOList (List<Customer> customerList) {
        List<EventCustomerDTO> eventCustomerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            eventsList = new ArrayList<>();

            EventCustomerDTO eventCustomerDTO = new EventCustomerDTO();
            eventCustomerDTO.setId(customer.getId());
            eventCustomerDTO.setFirstName(customer.getFirstName());
            eventCustomerDTO.setLastName(customer.getLastName());

            customer.getEvents().forEach((event) -> {
                Event event1 = new Event();
                event1.setId(event.getId());
                event1.setTitle(event.getTitle());
                event1.setData(event.getData());
                event1.setAvailable(event.getAvailable());
                event1.setPrice(event.getPrice());
                eventsList.add(event1);
            });
            eventCustomerDTO.setEventsList(eventsList);
            eventCustomerDTOList.add(eventCustomerDTO);
        }
        return eventCustomerDTOList;
    }

}