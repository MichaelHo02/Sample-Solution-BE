package com.example.enterprisemock.repo;

import com.example.enterprisemock.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from quizzes q where q.name ~~* :search or to_char(q.date_of_creation, 'yyyymmdd') ~~* " +
                    ":search",
            countQuery = "select count(*) from quizzes q " +
                    "where q.name ~~* :search or to_char(q.date_of_creation, 'yyyymmdd') ~~* :search"
    )
    Page<Quiz> findAllByNameContainingOrDateOfCreationContaining(
            @Param(value = "search") String search,
            Pageable pageable
    );
}