package com.example.tickets.mapper;

import com.example.tickets.dto.CustomerDTO;
import com.example.tickets.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CustomerMapper {
    CustomerMapper CUSTOMER_MAPPER= Mappers.getMapper(CustomerMapper.class);
    CustomerDTO fromCustomer (Customer customer);
    @InheritInverseConfiguration
    Customer toCustomer(CustomerDTO customerMapperDTO);
}
