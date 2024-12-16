package com.tickengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.tickengine.model.CinemaModel;
import com.tickengine.repository.CinemaRepository;

@Service
public class CinemaService {
    
    @Autowired
    CinemaRepository cinemaRepository;

    public List<CinemaModel> findAll(){
        return cinemaRepository.findAll();
    }

    public CinemaModel create(CinemaModel cinemaModel){
        if(validate(cinemaModel)){
            cinemaRepository.save(cinemaModel);
        }else{
            return null;
        }
        
        return cinemaModel;
    }

    public CinemaModel update(CinemaModel cinemaModel){
        if(validate(cinemaModel)){
            cinemaRepository.save(cinemaModel);
        }else{
            return null;
        }
        
        return cinemaModel;
    }

    public CinemaModel findById(Integer id){
        return cinemaRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id){
        cinemaRepository.deleteById(id);
    }

    private boolean validate(CinemaModel cinemaModel){
        
        if(cinemaModel.getName().isEmpty() || cinemaModel.getName().length() < 5){
            return false;
        }

        if(cinemaModel.getLocation().isEmpty()){
            return false;
        }

        if(cinemaModel.getEmail().isEmpty()){
            return false;
        }

        return true;
    }

}
