package com.tickengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.tickengine.model.CinemaModel;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaModel, Integer> {
    
}
