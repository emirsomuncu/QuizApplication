package com.example.quizApplication.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizApplication.business.abstracts.QuestionService;
import com.example.quizApplication.dao.abstracts.QuestionDao;
import com.example.quizApplication.model.Question;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	QuestionDao questionDao;
	
	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions = this.questionDao.findAll();
		return questions;
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		List<Question> categoriedQuestions = this.questionDao.findByCategory(category);
		return categoriedQuestions;
	}

	@Override
	public void addQuestion(Question question) {
		this.questionDao.save(question);
	}

	@Override
	public void updateQuestion(Question question) {
		this.questionDao.save(question);
	}

	@Override
	public void deleteQuestion(int id ) {
		this.questionDao.deleteById(id);
	}

}
