package com.example.tickets.security.repositorySecurity;

import com.example.tickets.security.dtoSecurity.UserDTO;
import com.example.tickets.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

}
