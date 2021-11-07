package com.systems.project.assignment;

import com.systems.project.assignment.service.StudentJdbcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssignmentApplication {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Autowired
	StudentJdbcService jdbcService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AssignmentApplication.class, args);

		StudentJdbcService jdbcService = context.getBean(StudentJdbcService.class);
	}

}
