package com.example.course.controller;

import com.example.course.models.user.Role;
import com.example.course.models.user.User;
import com.example.course.repository.UserRepository;
import com.example.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/private/user/add")
    public void addUser() {
        userService.createUser(userService.getUsername(), Role.ROLE_USER, false);
    }

    @GetMapping("/api/private/user")
    public List<User> getUserList() {
        return userRepository.findAll();
    }





}
