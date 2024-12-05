package com.tickengine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickengine.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

}
