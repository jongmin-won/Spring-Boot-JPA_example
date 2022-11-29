package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.Users;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void userInsert(Users user) {
        userRepository.save(user);
    }

    public Iterable<Users> userSelect() {
        return userRepository.findAll();
    }
}