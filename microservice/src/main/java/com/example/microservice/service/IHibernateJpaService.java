package com.example.microservice.service;

import com.example.microservice.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface  IHibernateJpaService {
    @Transactional
    User testHibernateJpaTransaction(String account, String pswd);
}
