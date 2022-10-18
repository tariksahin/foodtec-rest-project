package com.foodtec.demorest.service;

import com.foodtec.demorest.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> listUsers(String name, Date registrationDate, Double income);

}