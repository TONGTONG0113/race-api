package com.takima.race.race.entities;

import java.time.LocalDate;

public class Race {
    private long id;
    private String name;
    private  LocalDate date;
    private String location;
    private int maxParticipants;
    public Race() {
    }
    public Race(long id, String name, LocalDate date, String location, int maxParticipants) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getMaxParticipants() {
        return maxParticipants;
    }
    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    

    


}
