package com.example.tickets.security.serviseSecurity.Imp;

import com.example.tickets.MapperUtil;
import com.example.tickets.security.dtoSecurity.UserDTO;
import com.example.tickets.security.model.Role;
import com.example.tickets.security.model.Status;
import com.example.tickets.security.model.User;
import com.example.tickets.security.repositorySecurity.RoleRepository;
import com.example.tickets.security.repositorySecurity.UserRepository;
import com.example.tickets.security.serviseSecurity.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;//кодирует пароль

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private ModelMapper modelMapper;

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> result = MapperUtil.convertList(userRepository.findAll(), this::convertToUserDTO);
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }

    public User updateUser (User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setFirstName (user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        User result =userRepository.save(existingUser);
        log.info("IN updateUser - user: {} successfully update", result);
        return  result;
    }

    public boolean existsByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return true;
        }
        return false;
    }

    public boolean existsByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        if(user != null) {
            return true;
        }
        return false;
    }

}
