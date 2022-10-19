package com.foodtec.demorest.repository;

import com.foodtec.demorest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   List<User> findByNameAndRegistrationDateAfterAndIncomeGreaterThan(String name, Date registrationDate, BigDecimal income);
    List<User> findByNameAndRegistrationDateAfter(String name, Date registrationDate);
    List<User> findByNameAndIncomeGreaterThan(String name, BigDecimal income);
    List<User> findByRegistrationDateAfterAndIncomeGreaterThan(Date registrationDate, BigDecimal income);
    List<User> findByName(String name);
   List<User> findByRegistrationDate(Date registrationDate);
    List<User> findByIncomeGreaterThan(BigDecimal income);

}
