package com.telecom.demo.controller.auth;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myEndPoint/")
public class LoginController {

    @GetMapping
    public String getAllUsers() {
        return "Hello Admin";
    }
}
