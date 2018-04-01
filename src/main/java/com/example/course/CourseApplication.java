package com.example.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

//	@Bean
//	public void CreateUser(@Autowired UserRepository userRepository) {
//		HashSet<Workbook> workbooks = new HashSet<>();
//		workbooks.add(new Workbook(
//				"new Workbook",
//				"Title is wirkbook",
//				"123",
//				"123djsjdgcsdcsdclmksdvcbnmsdmcnbsd"));
//		userRepository.save(new User("ld1995", Role.ROLE_USER, workbooks));
//	}

}

//new Workbook(
//				"new Workbook",
//				"Title is wirkbook",
//				"123",
//				"123djsjdgcsdcsdclmksdvcbnmsdmcnbsd")