package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(name = "NUM")
    private int number;
    @Column(name = "COST")
    private int cost;
//    @Column(name = "NAME")
//    private String name;
    @JsonIgnore
    @ManyToOne (cascade=CascadeType.ALL )
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY, optional = false,cascade=CascadeType.ALL )
    @JoinColumn(name = "customer_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;


}
