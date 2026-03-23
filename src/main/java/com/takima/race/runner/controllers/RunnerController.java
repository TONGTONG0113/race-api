package com.takima.race.runner.controllers;

import com.takima.race.runner.entities.Runner;
import com.takima.race.runner.services.RunnerService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/runners")
public class RunnerController {
    private final RunnerService runnerService;

    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping
    public List<Runner> getAll() {
        return runnerService.getAll();
    }

    @GetMapping("/{id}")
    public Runner getById(@PathVariable Long id) {
        return runnerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deletRunner(@PathVariable Long id){
        runnerService.delet(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Runner create(@RequestBody Runner runner) {
        return runnerService.create(runner);
        
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Runner modifierRunner(@PathVariable Long id, @RequestBody Runner updatedRunner){
        return runnerService.update(id,updatedRunner);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Runner> getByFirstName(@PathVariable String firstName) {
        return runnerService.getByFirstName(firstName);
    }
}
