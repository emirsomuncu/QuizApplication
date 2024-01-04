package com.example.quizApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizApplication.business.abstracts.QuizService;
import com.example.quizApplication.business.response.GetQuizQuestionsResponse;
import com.example.quizApplication.model.Response;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
public class QuizController {
	
	private QuizService quizService;
	//http://localhost:8080/quiz/create?category=java&numQ=5&title=DQuiz
	
	@PostMapping("/create")
	public String createQuiz(@RequestParam String category , @RequestParam int numQ , @RequestParam String title) {
		this.quizService.createQuiz(category ,numQ , title);
		return "quiz is created";
	}
	
	@GetMapping("/get/{id}")
	public List<GetQuizQuestionsResponse> getQuizQuestions(@PathVariable int id) {
		return this.quizService.getQuizQuestions(id);
	}
	@PostMapping("/calculate/{id}")
	public int submit(@PathVariable int id , @RequestBody List<Response> response) {
		return this.quizService.calculatePoint(id , response);
	}
}
