package com.example.course.controller;

import com.example.course.models.user.Role;
import com.example.course.models.user.User;
import com.example.course.repository.UserRepository;
import com.example.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/api/private/user/add", method = RequestMethod.GET, produces = "application/json")
    public void addUser() {
        userService.createUser(userService.getUsername(), Role.ROLE_USER, false);
    }

    @RequestMapping(value = "/api/private/user", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUserList() {
        return userRepository.findAll();
    }





}
