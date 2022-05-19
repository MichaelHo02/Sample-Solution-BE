package com.example.enterprisemock.entity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class QuizPagination<T> {
    public List<T> t;

    public Long totalPage;
    public Long totalElement;
}
