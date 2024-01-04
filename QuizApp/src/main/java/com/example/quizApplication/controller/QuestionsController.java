package com.example.quizApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizApplication.business.abstracts.QuestionService;
import com.example.quizApplication.model.Question;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionsController {

	private QuestionService questionService; 
	
	@GetMapping()
	public List<Question> getAllQuestion() {
		return this.questionService.getAllQuestion();
	}
	@GetMapping("/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category) {
		return this.questionService.getQuestionByCategory(category);
	}
	@PostMapping("/add")
	public String addQuestion(@RequestBody Question question) {
		this.questionService.addQuestion(question);
		return "Question added succesfully";
	}
	@PutMapping("/update")
	public String updateQuestion(@RequestBody Question question) {
		this.questionService.updateQuestion(question);
		return "Question updated succesfully";
	}
	@DeleteMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable int id ) {
		this.questionService.deleteQuestion(id);
		return "Question deleted succesfully";
	}
	
}
