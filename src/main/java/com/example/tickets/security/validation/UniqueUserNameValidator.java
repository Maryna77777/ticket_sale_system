package com.example.tickets.security.validation;

import com.example.tickets.security.serviseSecurity.Imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    UserServiceImpl userService;

    @Override
    public void initialize(UniqueUserName uniqueUserName) {

    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {

        return !userService.existsByUserName(userName);
    }

}
