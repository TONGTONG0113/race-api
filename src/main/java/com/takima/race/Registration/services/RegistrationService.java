package com.takima.race.Registration.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.takima.race.Registration.repositories.RegistrationRepository;
import com.takima.race.runner.entities.Runner;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    
    // GET Lister les participants d'une course
    

}
