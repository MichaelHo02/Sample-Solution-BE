package com.example.enterprisemock.repo;

import com.example.enterprisemock.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {
}
