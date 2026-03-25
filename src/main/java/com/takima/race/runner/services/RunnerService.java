package com.takima.race.runner.services;

import com.takima.race.Registration.entities.Registration;
import com.takima.race.Registration.repositories.RegistrationRepository;
import com.takima.race.runner.entities.Runner;
import com.takima.race.runner.repositories.RunnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;
    private final RegistrationRepository registrationRepository;
    

    

    public RunnerService(RunnerRepository runnerRepository, RegistrationRepository registrationRepository) {
        this.runnerRepository = runnerRepository;
        this.registrationRepository = registrationRepository;
    }

    //GET /runners
    public List<Runner> getAll() {
        return runnerRepository.findAll();
    }
    //
    public List<Runner> getByFirstName(String firstName) {
        return runnerRepository.findByFirstName(firstName);
    }

    //GET /runners/{id}
    public Runner getById(Long id) {
        return runnerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Runner %s not found", id)
                )
        );
    }

    //POST /runners
    public Runner create(Runner runner) {
        if (runner.getEmail()==null|| !runner.getEmail().contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid email"); 
        }
        return runnerRepository.save(runner);
    }
    //DELETE /runners/{id}
    public void delet(Long id){
        registrationRepository.deleteAll(registrationRepository.findByRunnerId(id));
        
        runnerRepository.deleteById(id);
    }

    //PUT /runners/{id}
    public Runner update(Long id, Runner updatedRunner){//updateRunner是修改之后的 existing是修改之前的
        Runner existing = runnerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Runner %s not found", id)));
        if (updatedRunner.getEmail()==null || !updatedRunner.getEmail().contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid email");   
        }
        if (runnerRepository.existsByEmail(updatedRunner.getEmail()) && !existing.getEmail().equals(updatedRunner.getEmail())) { //新邮箱不等于旧邮箱，如果不加这个条件 只改姓名和年龄会报错
    
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        existing.setFirstName(updatedRunner.getFirstName());
        existing.setLastName(updatedRunner.getLastName());
        existing.setEmail(updatedRunner.getEmail());
        existing.setAge(updatedRunner.getAge());
        return runnerRepository.save(existing);
        
        
    }

    public List<Registration> getByRunnerId(Long runnerId){
        runnerRepository.findById(runnerId).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("runner no found")));
        return registrationRepository.findByRunnerId(runnerId);
    }







}
