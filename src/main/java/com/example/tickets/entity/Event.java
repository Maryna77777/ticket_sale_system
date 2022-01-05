package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="event")
@Component
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min=2, max=100, message = "Title should be between 2 and 100 character")
    @Column(name = "TITLE")
    private String title;

    @NotEmpty(message = "DATA should not be empty")
    @Future(message = "Date must be in the future")
    @Column (name = "DATA")
    private Date data;

    @Max(value = 10000,message = "Price should be less")
    @Column (name = "PRICE")
    private int price;

    @NotEmpty(message = "should not be empty")
    @Column (name = "AVAILABLE")
    private int available;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_customer",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    private List<Customer> customers;

    @JsonIgnore

    @OneToMany(mappedBy="event",cascade=CascadeType.ALL )
    private List<Sale> sales;

    public void setCustomer(Customer customer) {
    }

}
