package com.takima.race.Registration.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id,runnerId,raceId;
    private LocalDate registrationDate;
    public Registration() {
    }
    public Registration(Long id, Long runnerId, Long raceId, LocalDate registrationDate) {
        this.id = id;
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.registrationDate = registrationDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRunnerId() {
        return runnerId;
    }
    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }
    public Long getRaceId() {
        return raceId;
    }
    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    

}
