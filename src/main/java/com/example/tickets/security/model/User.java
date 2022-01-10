package com.example.tickets.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
@Table(name = "users",uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Data

public class User extends BaseEntity {

        @NotEmpty(message = "Username should not be empty")
        @Column(name = "username", unique=true)
        private String username;

        @NotEmpty(message = "First Name should not be empty")
        @Size(min=2, max=30, message = "First Name should be between 2 and 30 character")
        @Column(name = "first_name")
        private String firstName;

        @NotEmpty(message = "Last Name should not be empty")
        @Size(min=2, max=30, message = "Last Name should be between 2 and 30 character")
        @Column(name = "last_name")
        private String lastName;

        @NotEmpty(message = "Email should not be empty")
        @Email
        @Column(name = "email", unique=true)
        private String email;

        @NotEmpty(message = "Password should not be empty")
        @Column(name = "password")
        private String password;

        @Enumerated(EnumType.STRING)
        @Column(columnDefinition="enum('ACTIVE', 'NOT_ACTIVE', 'DELETED')")
        private Status status;


    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;


}

