package com.example.tickets.security.dtoSecurity;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
