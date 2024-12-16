package com.tickengine.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tickengine.service.UserService;


@Controller
@RequestMapping("/tickengine/user")
public class UserViewController {
    
    @Autowired
    UserService userService;

    @GetMapping("")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/userPanel";
    }
    
}
