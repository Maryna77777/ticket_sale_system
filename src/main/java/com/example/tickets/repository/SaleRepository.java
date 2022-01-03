package com.example.tickets.repository;

import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository <Sale,Long>{

    Sale findByIdAndCustomerId(Long id,  Long customerId);

    Sale findByEventIdAndCustomerId(Long eventId, Long customerId);

    List<Sale> findByCustomerId(Long customerId);

    List<Sale> findByEventId(Long eventId);

}


