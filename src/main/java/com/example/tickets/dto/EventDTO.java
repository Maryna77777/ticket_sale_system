package com.example.tickets.dto;

import com.example.tickets.entity.Event;
import com.example.tickets.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import lombok.Value;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter

public class EventDTO {

    private String title;
    private Date data;

    @Transactional
    public List<EventDTO> getEventDTOList(List<Event> eventList) {
        List<EventDTO> eventDTOList = new ArrayList<>();
        for (Event event: eventList ) {
            EventDTO eventDTO = new EventDTO();
            eventDTO.setTitle(event.getTitle());
            eventDTO.setData(event.getData());
            eventDTOList.add(eventDTO);
        }

        return eventDTOList;

    }


}
