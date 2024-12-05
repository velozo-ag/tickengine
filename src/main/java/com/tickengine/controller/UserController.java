package com.tickengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketsapi/user")
public class UserController {

    @GetMapping("")
    public String getHome() {
        return "users";
    }

    @GetMapping("/{nombre}")
    public String getNombre(@PathVariable String nombre) {
        return "chau " + nombre;
    }

}
