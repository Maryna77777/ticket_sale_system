package com.example.tickets.repository;

import com.example.tickets.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository  extends JpaRepository<Customer,Long> {

}
