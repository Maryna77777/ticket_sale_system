package com.example.tickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="customer")
public class Customer {

    @Id
    private long id;

    @NotEmpty(message = "First Name should not be empty")
    @Size(min=2, max=30, message = "First Name should be between 2 and 30 character")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty(message = "Last Name should not be empty")
    @Size(min=2, max=30, message = "Last Name should be between 2 and 30 character")
    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "customers",cascade=CascadeType.MERGE )
    private List<Event> events;

    @JsonIgnore
    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL )
    private List<Sale> sales;


}
