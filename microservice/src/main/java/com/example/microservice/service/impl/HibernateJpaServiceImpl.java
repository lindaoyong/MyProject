package com.example.microservice.service.impl;

import com.example.microservice.entity.User;
import com.example.microservice.repository.UserRepository;
import com.example.microservice.service.IHibernateJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HibernateJpaServiceImpl implements IHibernateJpaService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User testHibernateJpaTransaction(String account,String pswd) {
        User users = userRepository.findByName(account,pswd);
        return users;
    }
}
