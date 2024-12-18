package com.tickengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickengine.model.CinemaModel;
import com.tickengine.model.UserModel;
import com.tickengine.service.CinemaService;
import com.tickengine.service.UserService;

@RestController
@RequestMapping("/tickengine/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserModel> listAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserModel findUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping()
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable Integer id) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

}
