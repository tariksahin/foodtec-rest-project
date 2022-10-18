package com.foodtec.demorest.service;

import com.foodtec.demorest.entity.User;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> listUsers(String name, Date registrationDate, BigDecimal income);
}