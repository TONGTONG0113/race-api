package com.takima.race.Registration.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.takima.race.Registration.entities.Registration;
import com.takima.race.Registration.services.RegistrationService;
@RestController
@RequestMapping("/races")
public class RegistrationController {
    private RegistrationService registrationService;
    

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/{raceId}/registrations")
    @ResponseStatus(HttpStatus.CREATED)
    public Registration register(@PathVariable Long raceId, @RequestParam Long runnerId){

        return registrationService.register(raceId, runnerId);
    }

    @GetMapping("/{raceId}/registrations")
    public List<Registration> getByRaceId(@PathVariable Long raceId){
        return registrationService.getByRaceId(raceId);
    }

    

}
