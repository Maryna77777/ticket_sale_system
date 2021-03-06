package com.example.tickets.security.dtoSecurity;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
