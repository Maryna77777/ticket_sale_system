package com.example.tickets.repository;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {
}
