package com.example.tickets.security.serviseSecurity;

import com.example.tickets.security.dtoSecurity.UserDTO;
import com.example.tickets.security.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<UserDTO> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
