package com.takima.race.Race.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.takima.race.Race.entities.Race;
import com.takima.race.Race.services.RaceService;
@Controller
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;
    

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> getAll(){
        return raceService.getAll();

    }

    @GetMapping("/{id}")
    public Race getById(Long id){
        return raceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Race creat(Race race){
        return raceService.create(race);
    }

    @GetMapping("/{raceId}/participants/count")
    public int countParticipants(Long raceId){
        return raceService.countParticipants(raceId);
    }





    


}
