package com.example.quizApplication.dao.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.quizApplication.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer>{

	public List<Question> findByCategory(String category);

	@Query(value = "Select * from question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ" , nativeQuery = true)
	public List<Question> findByCategoryAndNumber(String category, int numQ);
}
