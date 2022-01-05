package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "FIRST NAME should not be empty")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty(message = "LAST NAME should not be empty")
    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "customers",cascade=CascadeType.MERGE )
    private List<Event> events;
    @JsonIgnore
    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL )
    private List<Sale> sales;
}
