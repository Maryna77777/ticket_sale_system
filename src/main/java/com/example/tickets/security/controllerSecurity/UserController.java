package com.example.tickets.security.controllerSecurity;


import com.example.tickets.entity.Event;
import com.example.tickets.security.CurrentUser;
import com.example.tickets.security.jwt.JwtUser;
import com.example.tickets.security.model.User;
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
    private SaleService service;

    @RequestMapping("/getCurrentUser")
    public User getCurrentUser(Principal principal) {

        String username = principal.getName();
        User user = new User();
        if (null != username) {
            user = userService.findByUsername(username);
        }
        return user;
    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView index(Principal user) {
//        ModelAndView mav= new ModelAndView("/web/index");
//        mav.addObject("user", user);
//        return mav;
//    }

    @RequestMapping(value = "/self",method = RequestMethod.GET)
    public UserDetails getUser(@AuthenticationPrincipal UserDetails user){
        return user;
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

    @Secured({"ROLE_MANAGER"})
    @GetMapping("/event")
    public List<Event> findAllEvents1(@AuthenticationPrincipal JwtUser user) {
        return eventService.getEvent ();
    }

}
