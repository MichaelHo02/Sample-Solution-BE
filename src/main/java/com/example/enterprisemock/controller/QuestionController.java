package com.example.enterprisemock.controller;


import com.example.enterprisemock.entity.Question;
import com.example.enterprisemock.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
public class QuestionController {
    private QuestionService questionService;

    @PostMapping("/quizzes/{quizId}/questions")
    public Question addQuestion(
            @PathVariable int quizId,
            @RequestBody Question input
    ) {
        return questionService.addQuestion(quizId, input);
    }

    @PutMapping("/questions/{questionId}")
    public Question updateQuestion(
            @PathVariable int questionId,
            @RequestBody Question input
    ) {
        return questionService.updateQuestion(questionId, input);
    }

    @DeleteMapping("/questions/{questionId}")
    public void deleteQuestion(@PathVariable int questionId) {
        questionService.deleteQuestion(questionId);
    }
}
