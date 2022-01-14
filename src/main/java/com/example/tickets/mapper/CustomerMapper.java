package com.example.tickets.mapper;

import com.example.tickets.dto.CustomerMapperDTO;
import com.example.tickets.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CustomerMapper {
    CustomerMapper CUSTOMER_MAPPER= Mappers.getMapper(CustomerMapper.class);
    CustomerMapperDTO fromCustomer (Customer customer);
    @InheritInverseConfiguration
    Customer toCustomer(CustomerMapperDTO customerMapperDTO);
}
