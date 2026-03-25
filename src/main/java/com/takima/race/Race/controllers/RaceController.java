package com.takima.race.Race.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.takima.race.Race.entities.Race;
import com.takima.race.Race.services.RaceService;
@RestController
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
    public Race getById(@PathVariable Long id){
        return raceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Race creat(@RequestBody Race race){
        return raceService.create(race);
    }

    @GetMapping("/{raceId}/participants/count")
    public int countParticipants(@PathVariable Long raceId){
        return raceService.countParticipants(raceId);
    }





    


}
