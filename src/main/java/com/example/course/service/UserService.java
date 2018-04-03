package com.example.course.service;

import com.example.course.models.user.Role;
import com.example.course.models.user.User;
import com.example.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(String username, Role role, boolean blocked) {
        if(!isExist(username)) {
            userRepository.save(new User(username, role, blocked));
        }
    }

    public boolean isExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal().toString();
    }

}
