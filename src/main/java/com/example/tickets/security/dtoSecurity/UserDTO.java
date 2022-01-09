package com.example.tickets.security.dtoSecurity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
