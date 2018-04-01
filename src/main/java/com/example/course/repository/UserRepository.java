package com.example.course.repository;

import com.example.course.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByUsername(String username);

    User getUserById(Long id);
}
