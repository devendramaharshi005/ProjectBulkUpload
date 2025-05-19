package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> saveAll(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}