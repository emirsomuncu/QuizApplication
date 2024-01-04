package com.example.quizApplication.business.abstracts;

import java.util.List;

import com.example.quizApplication.model.Question;

public interface QuestionService {

	public List<Question> getAllQuestion();
	public List<Question> getQuestionByCategory(String category);
	public void addQuestion(Question question);
	public void updateQuestion(Question question);
	public void deleteQuestion(int id );
}
