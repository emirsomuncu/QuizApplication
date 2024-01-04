package com.example.quizApplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication1Application.class, args);
	}

	@Bean
	public ModelMapper modelMapperStarter() {
		return new ModelMapper();
	}
}
