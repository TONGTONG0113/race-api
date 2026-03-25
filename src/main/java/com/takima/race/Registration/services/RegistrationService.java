package com.takima.race.Registration.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.takima.race.Race.entities.Race;
import com.takima.race.Race.repositories.RaceRepository;
import com.takima.race.Registration.entities.Registration;
import com.takima.race.Registration.repositories.RegistrationRepository;
import com.takima.race.runner.repositories.RunnerRepository;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;

    
    
    public RegistrationService(RegistrationRepository registrationRepository, RunnerRepository runnerRepository,
            RaceRepository raceRepository) {
        this.registrationRepository = registrationRepository;
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
    }



    //POST inscrire
    public Registration register(Long raceId, Long runnerId){
        //检查runner
        runnerRepository.findById(runnerId).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("runner no found",runnerId)));
        //检查race
        Race race =raceRepository.findById(raceId).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("race no found",raceId)));
        //Un coureur ne peut pas être inscrit deux fois à la même course
        if (registrationRepository.findByRaceIdAndRunnerId(raceId,runnerId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,String.format("déja registred"));
        }
        //Une course ne peut pas dépasser son nombre maximum de participants
        if (registrationRepository.countByRaceId(raceId) > race.getMaxParticipants()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("completed"));
            
        }
        //申请
        Registration reg= new Registration();
        reg.setRaceId(raceId);
        reg.setRunnerId(runnerId);
        reg.setRegistrationDate(LocalDate.now());

        return registrationRepository.save(reg);

    }
    //GET
    public List<Registration> getByRaceId(Long raceId){//返回list是因为一个比赛会有很多歌参赛者报名
        raceRepository.findById(raceId).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("race no found")));
        return registrationRepository.findByRaceId(raceId);
    }

    public List<Registration> getByRunnerId(Long runnerId){//pareil que race
        runnerRepository.findById(runnerId).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("runner no found")));
        return registrationRepository.findByRunnerId(runnerId);
    }

    

}
