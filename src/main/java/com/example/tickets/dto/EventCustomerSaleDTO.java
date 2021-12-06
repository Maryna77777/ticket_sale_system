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
public class EventCustomerSaleDTO {
    private long id;
    private String title;
    private List<Sale> saleList;
    private List<Customer> customerList;

    @Transactional
    public List<EventCustomerSaleDTO> getEventCustomerSaleDTO (List <Event> eventList) {
        List<EventCustomerSaleDTO> eventCustomerSaleDTOList = new ArrayList<>();
        for (Event event : eventList) {
            customerList = new ArrayList<>();
            saleList = new ArrayList<>();
            EventCustomerSaleDTO eventCustomerSaleDTO  = new EventCustomerSaleDTO();
            eventCustomerSaleDTO.setId(event.getId());
            eventCustomerSaleDTO.setTitle(event.getTitle());

            event.getSales().forEach((sale) -> {
                Sale sale1 = new Sale();
                sale1.setId(sale1.getId());
                sale1.setNumber(sale.getNumber());
                sale1.setCost(sale.getCost());
                saleList.add(sale1);
            });
            event.getCustomers().forEach((customer) -> {
                Customer customer1 = new Customer();
                customer1.setId(customer1.getId());
                 customer1.setFirstName(customer.getFirstName());
                 customer1.setLastName(customer.getLastName());
                 customerList.add((customer1));
            });
            eventCustomerSaleDTO.setSaleList(saleList);
            eventCustomerSaleDTO.setCustomerList(customerList);
            eventCustomerSaleDTOList.add(eventCustomerSaleDTO);
        }
        return eventCustomerSaleDTOList;
    }

     

}


