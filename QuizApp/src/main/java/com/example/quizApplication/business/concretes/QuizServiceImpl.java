package com.example.quizApplication.business.concretes;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.quizApplication.business.abstracts.QuizService;
import com.example.quizApplication.business.response.GetQuizQuestionsResponse;
import com.example.quizApplication.core.utilites.mappers.ModelMapperService;
import com.example.quizApplication.dao.abstracts.QuestionDao;
import com.example.quizApplication.dao.abstracts.QuizDao;
import com.example.quizApplication.model.Question;
import com.example.quizApplication.model.Quiz;
import com.example.quizApplication.model.Response;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

	private QuestionDao questionDao; 
	private QuizDao quizDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public void createQuiz(String category, int numQ, String title) {
		
		List<Question> quizQuestions = this.questionDao.findByCategoryAndNumber(category , numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(quizQuestions);
		
		this.quizDao.save(quiz);
		
	}

	@Override
	public List<GetQuizQuestionsResponse> getQuizQuestions(int id) {
		
		Optional<Quiz> quiz = this.quizDao.findById(id);
		List<Question> questions = quiz.get().getQuestion();
		
		List<GetQuizQuestionsResponse> quizQuestionsResponse = questions.stream().map(qqr->this.modelMapperService.forResponse()
				.map(qqr,GetQuizQuestionsResponse.class)).toList();
		
		return quizQuestionsResponse;
	}

	@Override
	public int calculatePoint(int id, List<Response> response) {
		
		Optional<Quiz> quiz = this.quizDao.findById(id);
		List<Question> questions = quiz.get().getQuestion();
		
		int i = 0 ;
		int Right = 0;
		
		for (Response rp : response ) {
		if(rp.getEnteredResponse().equals(questions.get(i).getRightAnswer())) {
			Right++ ;
			}
		i++;
		}
		
		return Right;
	}


}
