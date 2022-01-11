package com.example.tickets.security.validation;


import com.example.tickets.security.serviseSecurity.Imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator <UniqueEmail, String> {

        @Autowired
        UserServiceImpl userService;

        @Override
        public void initialize(UniqueEmail uniqueEmail) {

        }

        @Override
        public boolean isValid(String email, ConstraintValidatorContext context) {

                return !userService.existsByEmail(email);
        }

}





