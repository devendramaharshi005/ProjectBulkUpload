package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/bulk")
    public List<User> addUsers(@RequestBody List<User> users) {
        return service.saveAll(users);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAll();
    }
}