package com.foodtec.demorest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String email;
    private String phone;
    private String password;
    private Date registrationDate;
    private BigDecimal income;

    public String getPhone() {
        return phone.replaceAll("\\d(?=(?:\\D*\\d){4})", "*");
    }
    public String getPassword() {
        return password.replaceAll("[^\\d\\+]", "*");
    }

}
