package com.foodtec.demorest.service;

import com.foodtec.demorest.entity.User;
import com.foodtec.demorest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> listUsers(String name, Date registrationDate, BigDecimal income) {

       if(ObjectUtils.allNull(name,registrationDate,income)) {
            return userRepository.findAll();
        }
        if(ObjectUtils.allNotNull(name,registrationDate, income)){
            return userRepository.findByNameAndRegistrationDateAfterAndIncomeGreaterThan(name,registrationDate,income);
        }
        if(Objects.isNull(income) && ObjectUtils.allNotNull(name,registrationDate)){
            return userRepository.findByNameAndRegistrationDateAfter(name, registrationDate);
        }
        if(Objects.isNull(registrationDate) && ObjectUtils.allNotNull(name,income)){
            return userRepository.findByNameAndIncomeGreaterThan(name, income);
        }
        if(Objects.isNull(name) && ObjectUtils.allNotNull(registrationDate,income)){
            return userRepository.findByRegistrationDateAfterAndIncomeGreaterThan(registrationDate, income);
        }
        if((ObjectUtils.allNull(registrationDate, income) && Objects.nonNull(name))){
            return userRepository.findByName(name);
        }
       if((ObjectUtils.allNull(name, income) && Objects.nonNull(registrationDate))){
            return userRepository.findByRegistrationDate(registrationDate);
        }
        if((ObjectUtils.allNull(name, registrationDate)) && Objects.nonNull(income)){
            return userRepository.findByIncomeGreaterThan(income);
        }
        return Collections.emptyList();
    }

}