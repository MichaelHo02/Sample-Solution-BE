package com.example.enterprisemock.repo;

import com.example.enterprisemock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(
            value = "select * from users u where u.name ~~* :name",
            nativeQuery = true
    )
    User findByName(@Param(value = "name") String name);
}
