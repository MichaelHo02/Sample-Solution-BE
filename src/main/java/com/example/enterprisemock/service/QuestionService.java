package com.example.enterprisemock.service;

import com.example.enterprisemock.entity.Answer;
import com.example.enterprisemock.entity.Question;
import com.example.enterprisemock.entity.Quiz;
import com.example.enterprisemock.repo.QuestionRepo;
import com.example.enterprisemock.repo.QuizRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService {
    private QuestionRepo questionRepo;
    private QuizRepo quizRepo;

    public Question addQuestion(int quizId, Question question) {
        Quiz quiz = quizRepo.findById(quizId).orElseThrow(() -> new RuntimeException("Cannot find quiz"));
        for (Answer answer : question.getAnswers()) {
            answer.setQuestion(question);
        }
        quiz.addQuestion(question);
        return questionRepo.save(question);
    }

    public Question updateQuestion(int questionId, Question input) {
//        Question question1 = questionRepo
//                .findById(questionId).orElseThrow(
//                        () -> new RuntimeException("Cannot find question")
//                );
//        if (!question1.getContent().equals(input.getContent())) {
//            question1.setContent(input.getContent());
//        }
//        question1.setAnswers(input.getAnswers());
//        return question1;

        input.setId(questionId);
        return questionRepo.save(input);
    }

    public void deleteQuestion(int questionId) {
        Question question = questionRepo.findById(questionId).orElseThrow(() -> new RuntimeException("abc"));
        questionRepo.delete(question);
    }
}
