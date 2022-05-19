package com.example.enterprisemock.service;

import com.example.enterprisemock.entity.Quiz;
import com.example.enterprisemock.repo.QuizRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuizService {
    private QuizRepo quizRepo;

    public List<Quiz> getQuizzes(String search, Pageable pageable) {
        Page<Quiz> page = quizRepo.findAllByNameContainingOrDateOfCreationContaining("%" + search + "%", pageable);
        System.out.println(page);
        if (page.hasContent()) {
            return page.getContent();
        }
        return new ArrayList<>();
    }
}
