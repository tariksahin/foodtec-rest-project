package com.foodtec.demorest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user-list")
    public String hello(){
        return "hello";
    }
}
