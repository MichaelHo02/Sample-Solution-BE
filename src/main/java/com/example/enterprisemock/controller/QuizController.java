package com.example.enterprisemock.controller;

import com.example.enterprisemock.entity.Quiz;
import com.example.enterprisemock.entity.QuizPagination;
import com.example.enterprisemock.entity.User;
import com.example.enterprisemock.service.QuizService;
import com.example.enterprisemock.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class QuizController {
    private QuizService quizService;
    private UserService userService;

    @GetMapping(value = "/quizzes")
    public QuizPagination<Quiz> getQuizzes(
            @RequestParam(value = "search", defaultValue = "", required = false) String search,
            @RequestParam(value = "isAscending", defaultValue = "true", required = false) boolean isAscending,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "4", required = false) int limit,
            @RequestHeader(name = "basics", defaultValue = "", required = false) String basics
    ) {
        List<String> basicsList = List.of(basics.split(":"));
        User user = userService.getUser(basicsList.get(0));
        if (user.getName().equals(basicsList.get(0)) && user.getPassword().equals(basicsList.get(1))) {
            Pageable pageable = isAscending ?
                    PageRequest.of(page, limit, Sort.by("name", "date_of_creation").ascending()) :
                    PageRequest.of(page, limit, Sort.by("name", "date_of_creation").descending());

            return quizService.getQuizzes(search, pageable);
        }
        return null;
    }
}
