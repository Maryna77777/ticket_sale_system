package com.example.tickets.entity;

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
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column (name = "DATA")
    private String data;
    @Column (name = "PRICE")
    private int price;
    @Column (name = "AVAILABLE")
    private int available;
    @ManyToMany(mappedBy = "events")
    private List<Customer> customers;

}
