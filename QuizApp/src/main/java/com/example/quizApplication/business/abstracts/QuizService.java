package com.example.quizApplication.business.abstracts;

import java.util.List;

import com.example.quizApplication.business.response.GetQuizQuestionsResponse;
import com.example.quizApplication.model.Response;

public interface QuizService {

	public void createQuiz(String category, int numQ, String title);

	public List<GetQuizQuestionsResponse> getQuizQuestions(int id);

	public int calculatePoint(int id, List<Response> response);

}
