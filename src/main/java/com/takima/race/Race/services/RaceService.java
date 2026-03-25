package com.takima.race.Race.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.takima.race.Race.entities.Race;
import com.takima.race.Race.repositories.RaceRepository;
import com.takima.race.Registration.repositories.RegistrationRepository;


@Service
public class RaceService {
    private final RaceRepository raceRepository;
    private final RegistrationRepository registrationRepository;
    
    

    public RaceService(RaceRepository raceRepository, RegistrationRepository registrationRepository) {
        this.raceRepository = raceRepository;
        this.registrationRepository = registrationRepository;
    }

    //GET
    public List<Race> getAll(){
        return raceRepository.findAll();

    }

    //GET/ID
    public Race getById(Long id) {
        return raceRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Race not found", id)
                )
        );
    }

    //POST
    public Race create(Race race) {
        return raceRepository.save(race);
    }

    //GET ID 统计参数人数 要看有多少人申请 就要看inscription
    public int countParticipants(Long raceId) {
        //检查比赛是存在的
        raceRepository.findById(raceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return registrationRepository.countByRaceId(raceId);
    }

    //PUT
    public Race update(Long id, Race updatedRace){
        Race existing = raceRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Race not found", id)));
       
        existing.setName(updatedRace.getName());
        existing.setDate(updatedRace.getDate());
        existing.setLocation(updatedRace.getLocation());
        existing.setMaxParticipants(updatedRace.getMaxParticipants());

        return raceRepository.save(existing);
        
    }
   
    


}
