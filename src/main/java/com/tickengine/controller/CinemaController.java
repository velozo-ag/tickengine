package com.tickengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickengine.model.CinemaModel;
import com.tickengine.service.CinemaService;

@RestController
@RequestMapping("/tickengine/api/cinema")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping()
    public List<CinemaModel> listAll() {
        return cinemaService.findAll();
    }

    @GetMapping("/{id}")
    public CinemaModel findCinema(@PathVariable Integer id) {
        return cinemaService.findById(id);
    }

    @PostMapping()
    public CinemaModel createCinema(@RequestBody CinemaModel cinema) {
        return cinemaService.create(cinema);
    }

    @PutMapping("/{id}")
    public CinemaModel updateCinema(@RequestBody CinemaModel cinema, @PathVariable Integer id) {
        cinema.setId(id);
        return cinemaService.update(cinema);
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Integer id) {
        cinemaService.deleteById(id);
    }
}
