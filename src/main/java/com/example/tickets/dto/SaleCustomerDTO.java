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
public class SaleCustomerDTO  {
    private long id;
    private String firstName;
    private String lastName;
    private List<Sale> saleList;

    @Transactional
    public List<SaleCustomerDTO> getSaleCustomerDTOList (List<Customer> customerList) {
        List<SaleCustomerDTO> saleCustomerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            saleList = new ArrayList<>();


            SaleCustomerDTO saleCustomerDTO = new SaleCustomerDTO();
            saleCustomerDTO.setId(customer.getId());
            saleCustomerDTO.setFirstName(customer.getFirstName());
            saleCustomerDTO.setLastName(customer.getLastName());

            customer.getSales().forEach((sale) -> {
                Sale sale1 = new Sale();
                sale1.setNumber(sale.getNumber());
                sale1.setCost(sale.getCost());
                saleList.add(sale1);
            });
            saleCustomerDTO.setSaleList(saleList);
            saleCustomerDTOList.add(saleCustomerDTO);
        }
        return saleCustomerDTOList;
    }



}
