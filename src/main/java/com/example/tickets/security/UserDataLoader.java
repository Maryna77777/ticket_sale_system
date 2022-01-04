package com.example.tickets.security;

import com.example.tickets.entity.Sale;
import com.example.tickets.security.model.Role;
import com.example.tickets.security.model.Status;
import com.example.tickets.security.model.User;
import com.example.tickets.security.repositorySecurity.RoleRepository;
import com.example.tickets.security.repositorySecurity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component

public class UserDataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {

            Role roleAdmin =new Role();
            roleAdmin.setName("ROLE_ADMIN");
            Role roleManager =new Role();
            roleManager.setName("ROLE_MANAGER");
            Role roleUser =new Role();
            roleUser.setName("ROLE_USER");

            User user1 = new User();
            List<Role>roleList1 = new ArrayList<>();
            roleList1.add(roleAdmin);
            user1.setUsername("kolos");
            user1.setPassword(new BCryptPasswordEncoder().encode("test123"));
            user1.setEmail("kolos@gmail.com");
            user1.setLastName("Колос");
            user1.setFirstName("Олег");
            user1.setRoles(roleList1);
            user1.setStatus(Status.ACTIVE);

            User user2 = new User();
            List<Role>roleList2 = new ArrayList<>();
            roleList2.add(roleManager);
            user2.setFirstName("Олег");
            user2.setLastName("Шутов");
            user2.setUsername("shyt");
            user2.setEmail("shyt@gmail.com");
            user2.setPassword(new BCryptPasswordEncoder().encode("test12345"));
            user2.setRoles(roleList2);
            user2.setStatus(Status.ACTIVE);

            User user3 = new User();
            List<Role> roleList3 = new ArrayList<>();
            roleList3.add(roleUser);
            user3.setUsername("los");
            user3.setFirstName("Николай");
            user3.setLastName("Лосев");
            user3.setEmail("los@gmail.com");
            user3.setPassword(new BCryptPasswordEncoder().encode("test1234567"));
            user3.setRoles(roleList3);
            user3.setStatus(Status.ACTIVE);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

        }
        System.out.println(userRepository.count());
    }
}


