package com.example.tickets.security.repositorySecurity;

import com.example.tickets.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    User findByEmail (String email);
}
