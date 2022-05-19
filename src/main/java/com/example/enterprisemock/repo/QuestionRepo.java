package com.example.enterprisemock.repo;

import com.example.enterprisemock.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
