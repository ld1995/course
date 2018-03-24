package com.example.course;

import com.example.course.model.User;
import com.example.course.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

//    @Bean
//    public void demo(UserRepository repository) {
//        repository.save(new User());
//    }
}

