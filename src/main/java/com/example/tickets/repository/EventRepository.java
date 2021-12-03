package com.example.tickets.repository;

import com.example.tickets.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

    Event findByTitle(String title);
}
