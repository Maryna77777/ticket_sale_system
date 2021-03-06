package com.example.tickets.repository;

import com.example.tickets.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event,Long>{

    @Query("select e from Event e order by data")
    List<Event> findAllOrderByData();

    Event findByTitle(String title);

    @Query("select e from Event e join e.customers c where c.lastName = :lastName")
    List<Event> findByLastName(@Param("lastName") String lastName);


    @Query("select e from Event e join e.customers c where c.id = :id")
    List<Event> findByCustomerId(@Param("id") Long id);

}
