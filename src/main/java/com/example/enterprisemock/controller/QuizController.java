package com.example.enterprisemock.controller;

import com.example.enterprisemock.entity.Quiz;
import com.example.enterprisemock.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class QuizController {
    private QuizService quizService;

    @GetMapping(value = "/quizzes")
    public List<Quiz> getQuizzes(
            @RequestParam(value = "search", defaultValue = "", required = false) String search,
            @RequestParam(value = "isAscending", defaultValue = "true", required = false) boolean isAscending,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "4", required = false) int limit
    ) {
        Pageable pageable = isAscending ?
                PageRequest.of(page, limit, Sort.by("name", "date_of_creation").ascending()) :
                PageRequest.of(page, limit, Sort.by("name", "date_of_creation").descending());

        return quizService.getQuizzes(search, pageable);
    }
}
