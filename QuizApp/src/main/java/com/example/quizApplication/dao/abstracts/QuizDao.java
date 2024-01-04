package com.example.quizApplication.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizApplication.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
