package com.example.tickets.repository;

import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    @Query("select c from Customer c join c.events e where e.title = :title")
    List<Customer> findByTitle(@Param("title") String title);
}
