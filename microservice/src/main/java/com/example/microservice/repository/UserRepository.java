package com.example.microservice.repository;

import com.example.microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("from User t where t.loginAccount =:account and t.loginPwd=:pswd")
    User findByName(@Param(value = "account") String name,@Param(value = "pswd") String pswd);
}
