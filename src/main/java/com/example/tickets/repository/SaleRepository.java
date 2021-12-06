package com.example.tickets.repository;

import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository <Sale,Long>{

    Optional<Sale> findByIdAndCustomerId(Long id, Long customerId);

    List<Sale> findByCustomerId(Long customerId);

    List<Sale> findByEventId(Long eventId);

//    List<Sale> findByEventCustomerId(Long eventId,Long customerId);
}


