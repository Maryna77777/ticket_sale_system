package com.example.tickets.security.controllerSecurity;


import com.example.tickets.entity.Customer;
import com.example.tickets.entity.Event;
import com.example.tickets.security.CurrentUser;
import com.example.tickets.security.jwt.JwtUser;
import com.example.tickets.security.model.User;
import com.example.tickets.security.serviseSecurity.Imp.UserServiceImpl;
import com.example.tickets.security.serviseSecurity.UserService;
import com.example.tickets.service.EventService;
import com.example.tickets.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private UserServiceImpl service;

    @RequestMapping("/getCurrentUser")
    public User getCurrentUser(Principal principal) {
        String username = principal.getName();
        User user = new User();
        if (null != username) {
            user = userService.findByUsername(username);
        }
        return user;
    }

    @Secured("ROLE_MANAGER")
    @GetMapping()
    public List<User> findAllUsers() {
        return service.getAll();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping()
    public User addUser (@Valid @RequestBody User user) {
        return service.register(user);}


    @RequestMapping(value = "/self",method = RequestMethod.GET)
    public UserDetails getUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }


    @Secured("ROLE_ADMIN")
    @PutMapping()
    public User updateUser(@RequestBody @Valid  User user) {
        return service.updateUser(user);
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
       return principal.getName();
    }

    @RequestMapping("/current/show")
    public JwtUser show
                     (@CurrentUser JwtUser customUser)
//                   (@AuthenticationPrincipal JwtUser customUser)
           {
        return customUser;
    }

}
