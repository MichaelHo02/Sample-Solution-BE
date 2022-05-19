package com.example.enterprisemock.service;

import com.example.enterprisemock.entity.Quiz;
import com.example.enterprisemock.entity.QuizPagination;
import com.example.enterprisemock.repo.QuizRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class QuizService {
    private QuizRepo quizRepo;

    public QuizPagination<Quiz> getQuizzes(String search, Pageable pageable) {
        Page<Quiz> page = quizRepo.findAllByNameContainingOrDateOfCreationContaining("%" + search + "%", pageable);
        if (page.hasContent()) {

            return new QuizPagination<Quiz>(page.getContent(), (long) page.getTotalPages(), page.getTotalElements());
        }
        return new QuizPagination<Quiz>(new ArrayList<>(), (long) page.getTotalPages(), page.getTotalElements());
    }
}
