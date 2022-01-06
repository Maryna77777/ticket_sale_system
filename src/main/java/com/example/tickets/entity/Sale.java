package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
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

    private long user_id;

    @Min(value = 1, message = "should be more than 1")
    @Column(name = "NUM")
    private int number;

    @Positive(message = "Cost should be positive")
    @Column(name = "COST")
    private int cost;

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
