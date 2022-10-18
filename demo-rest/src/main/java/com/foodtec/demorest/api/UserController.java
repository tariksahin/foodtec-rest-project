package com.foodtec.demorest.api;

import com.foodtec.demorest.entity.User;
import com.foodtec.demorest.repository.UserRepository;
import com.foodtec.demorest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping(value = {"/list-users"})
    public List<User> getAll(String name, Date registrationDate, BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/name/{name}"})
    public List<User> findByName(@PathVariable("name") String name, Date registrationDate, BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/date/{registrationDate}"})
    public List<User> findByRegistrationDate(String name, @PathVariable("registrationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date registrationDate, BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/income/{income}"})
    public List<User> findByIncome(String name, Date registrationDate, @PathVariable("income") BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/name-date/{name}/{registrationDate}"})
    public List<User> findByNameAndRegistrationDate(@PathVariable("name") String name, @PathVariable("registrationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date registrationDate, BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/name-income/{name}/{income}"})
    public List<User> findByNameAndIncome(@PathVariable("name") String name, Date registrationDate,  @PathVariable("income")  BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/date-income/{registrationDate}/{income}"})
    public List<User> findByRegistrationDateAndIncome(String name, @PathVariable("registrationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date registrationDate, @PathVariable("income") BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

    @GetMapping(value = {"/list-users/all/{name}/{registrationDate}/{income}"})
    public List<User> findByAllCriteria(@PathVariable("name") String name, @PathVariable("registrationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date registrationDate, @PathVariable("income") BigDecimal income){
        return userService.listUsers(name,registrationDate, income);
    }

}
