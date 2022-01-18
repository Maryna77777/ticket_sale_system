package com.example.tickets.repository;

import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event,Long>{

    @Query("select e from Event e order by data")
    List<Event> findAllOrderByData();

    Event findByTitle(String title);

    @Query("select e from Event e join e.customers c where c.lastName = :lastName")
    List<Event> findByLastName(@Param("lastName") String lastName);

    @Query("delete from Event e where e.id = :id")
    Event removeById (Long id);

}
