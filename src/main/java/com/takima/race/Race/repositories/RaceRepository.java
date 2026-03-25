package com.takima.race.Race.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.race.Race.entities.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    List<Race> findByLocation(String locationg);
    

}
