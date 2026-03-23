package com.takima.race.Registration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.race.Registration.entities.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{
    List<Registration> findByRaceId(Long raceId);
    int countByRaceId(Long raceId);
}
