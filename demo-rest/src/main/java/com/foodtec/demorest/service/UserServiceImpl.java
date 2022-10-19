package com.foodtec.demorest.service;

import com.foodtec.demorest.entity.User;
import com.foodtec.demorest.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> listUsers(String name, Date registrationDate, BigDecimal income) {
        log.info("Listing users for input(s); name; {} date;{} income;{}", name, registrationDate, income);

        //We are just fetcing data so ArrayList is going to be enough.
        List<User> userList = new ArrayList<>();
        
       if(ObjectUtils.allNull(name,registrationDate,income)) {
           log.info("All search criterias are null , returning all users");
           userList = userRepository.findAll();
        }
        if(ObjectUtils.allNotNull(name,registrationDate, income)){
            log.info("All search criterias are null , returning all users");
            userList = userRepository.findByNameAndRegistrationDateAfterAndIncomeGreaterThan(name,registrationDate,income);
        }
        if(Objects.isNull(income) && ObjectUtils.allNotNull(name,registrationDate)){
            log.info("Returning users with filtered parameters which are name and registrationDate");
            userList = userRepository.findByNameAndRegistrationDateAfter(name, registrationDate);
        }
        if(Objects.isNull(registrationDate) && ObjectUtils.allNotNull(name,income)){
            log.info("Returning users with filtered parameters which are name and income");
            userList = userRepository.findByNameAndIncomeGreaterThan(name, income);
        }
        if(Objects.isNull(name) && ObjectUtils.allNotNull(registrationDate,income)){
            log.info("Returning users with filtered parameters which are registrationDate and income");
            userList = userRepository.findByRegistrationDateAfterAndIncomeGreaterThan(registrationDate, income);
        }
        if((ObjectUtils.allNull(registrationDate, income) && Objects.nonNull(name))){
            log.info("Returning users with filtered parameters which is name");
            userList = userRepository.findByName(name);
        }
       if((ObjectUtils.allNull(name, income) && Objects.nonNull(registrationDate))){
           log.info("Returning users with filtered parameter which is registrationDate");
            userList = userRepository.findByRegistrationDate(registrationDate);
        }
        if((ObjectUtils.allNull(name, registrationDate)) && Objects.nonNull(income)){
            log.info("Returning users with filtered parameter which is income");
            userList = userRepository.findByIncomeGreaterThan(income);
        }
        maskSensitiveData(userList);
        return userList;
    }

    private void maskSensitiveData(List<User> users){
        users.forEach(eachUser -> {
            eachUser.setPhone(eachUser.getPhone().replaceAll("\\d(?=(?:\\D*\\d){3})", "*")); //stars without last 3 digits
            eachUser.setPassword(eachUser.getPassword().replaceAll("[^\\d\\+]", "*")); //stars whole word
        });
    }
}