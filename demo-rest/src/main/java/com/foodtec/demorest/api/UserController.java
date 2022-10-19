package com.foodtec.demorest.api;

import com.foodtec.demorest.entity.User;
import com.foodtec.demorest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = {"/list-users"})
    public List<User> listUsers(String name, @DateTimeFormat(pattern = "dd.MM.yyyy") Date registrationDate, BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }
}
