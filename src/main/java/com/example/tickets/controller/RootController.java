package com.example.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}
