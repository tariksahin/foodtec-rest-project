package com.foodtec.demorest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private Date registrationDate;

    private Double income;
}
