package com.example.tickets.security.controllerSecurity;


import com.example.tickets.entity.Event;
import com.example.tickets.security.model.User;
import com.example.tickets.security.serviseSecurity.UserService;
import com.example.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;

    @RequestMapping("/getCurrentUser")
    public User getCurrentUser(Principal principal) {

        String username = principal.getName();
        User user = new User();
        if (null != username) {
            user = userService.findByUsername(username);
        }
        return user;
    }


 //   @Secured({"ROLE_USER"})
    @GetMapping("/event")
    public List<Event> findAllEvents1(@AuthenticationPrincipal User user) {
        return eventService.getEvent ();
    }



}
