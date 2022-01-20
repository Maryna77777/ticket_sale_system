package com.example.tickets.security.controllerSecurity;



import com.example.tickets.security.CurrentUser;
import com.example.tickets.security.dtoSecurity.UserDTO;
import com.example.tickets.security.jwt.JwtUser;
import com.example.tickets.security.model.User;
import com.example.tickets.security.serviseSecurity.Imp.UserServiceImpl;
import com.example.tickets.security.serviseSecurity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl service;

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping("/CurrentUserPrincipal")
    public User getCurrentUser(Principal principal) {
        String username = principal.getName();
        User user = new User();
        if (null != username) {
            user = userService.findByUsername(username);
        }
        return user;
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping("/currentUsername")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping ("/currentUser")
    public JwtUser show(@CurrentUser JwtUser customUser)
    {
        return customUser;
    }

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @GetMapping()
    public List<UserDTO> findAllUsers() {
        return service.getAll();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping()
    public User addUser (@Valid @RequestBody User user) {
        return service.register(user);}

    @Secured("ROLE_ADMIN")
    @PutMapping()
    public User updateUser(@RequestBody @Valid  User user) {
        return service.updateUser(user);
    }

}
