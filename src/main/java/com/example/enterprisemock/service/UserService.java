package com.example.enterprisemock.service;

import com.example.enterprisemock.entity.User;
import com.example.enterprisemock.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(String name) {
        return userRepo.findByName(name);
    }
}
