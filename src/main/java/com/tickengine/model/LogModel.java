package com.tickengine.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.tickengine.enums.Level;

import jakarta.persistence.*;

public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    @CreatedDate
    private LocalDateTime timestamp;

    private Level level;
    private String action;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    private String entity_name;
    private Integer entity_id;

    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private CinemaModel cinema;

}
