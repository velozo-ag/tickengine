package com.tickengine.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tickengine.model.CinemaModel;
import com.tickengine.service.CinemaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/tickengine/cinema")
public class CinemaViewController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping("")
    public String getCinemas(Model model) {
        model.addAttribute("cinemasLength", cinemaService.findAll().size());
        model.addAttribute("cinemas", cinemaService.findAll());
        return "cinema/cinemaPanel";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("cinema", new CinemaModel());
        return "cinema/create";
    }
    
    @PostMapping("/create")
    public String saveCinema(@ModelAttribute CinemaModel cinema, Model model) {
        
        if (cinemaService.create(cinema) == null) {
            model.addAttribute("error", "Error saving new cinema");
            model.addAttribute("cinema", cinema);
            return "cinema/create";
        } else {
            return "redirect:/tickengine/cinema";
        }
    }
    
    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable Integer id) {
        model.addAttribute("cinema", cinemaService.findById(id));
        return "cinema/update";
    }
    
    @PutMapping("/update/{id}")
    public String updateCinema(@ModelAttribute CinemaModel cinema, Model model) {
        
        if (cinemaService.update(cinema) == null) {
            model.addAttribute("error", "Error updating cinema");
            model.addAttribute("cinema", cinema);
            return "cinema/update";
        } else {
            return "redirect:/tickengine/cinema";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteCinema(@PathVariable Integer id) {
        cinemaService.deleteById(id);
        return "redirect:/tickengine/cinema";
    }
    

}
