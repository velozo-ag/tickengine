package com.tickengine.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/tickengine")
public class MainController {
    
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("test", "Testmesssage");
        return "mainPanel";
    }
    
}
