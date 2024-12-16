package com.tickengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickengine.model.UserModel;
import com.tickengine.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public UserModel findById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public UserModel create(UserModel userModel){
        return userRepository.save(userModel);
    }

    public UserModel update(UserModel userModel){
        return userRepository.save(userModel);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }
}
