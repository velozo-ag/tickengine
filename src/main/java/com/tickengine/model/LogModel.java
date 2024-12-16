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
    
    @Column(nullable = false)
    private Level level;
    @Column(nullable = false)
    private String action;
    @Column(nullable = false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;
    
    private String entity_name;
    private Integer entity_id;
    
    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    @Column(nullable = false)
    private CinemaModel cinema;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public Integer getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Integer entity_id) {
        this.entity_id = entity_id;
    }

    public CinemaModel getCinema() {
        return cinema;
    }

    public void setCinema(CinemaModel cinema) {
        this.cinema = cinema;
    }

}
