package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // change to event_id
    @Column(name = "TITLE_EVENT")
    private String title;
    @Column(name = "NUM")
    private int number;
    @Column(name = "COST")
    private int cost;
    @Column(name = "NAME")
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "sales")
    private List<Event> events;
}
