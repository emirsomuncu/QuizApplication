package com.example.quizApplication.business.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetQuizQuestionsResponse {

	private int id;
	
	private String questionTitle;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	
}