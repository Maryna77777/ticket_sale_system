package com.example.tickets.mapper;

import com.example.tickets.dto.EventDTO;
import com.example.tickets.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper (uses = CustomerMapper.class)
/*(uses = CustomerMapper.class)*/
/*(uses = SaleMapper.class)*/
public interface EventMapper {
    EventMapper EVENT_MAPPER=Mappers.getMapper(EventMapper.class);
    EventDTO fromEvent(Event event);
}



