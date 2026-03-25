package com.takima.race.Registration.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.race.Registration.entities.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{

    int countByRaceId(Long raceId);
    List<Registration> findByRaceId(Long raceId);
    List<Registration> findByRunnerId(Long runnerId);
    Optional<Registration> findByRaceIdAndRunnerId(Long raceId, Long runnerId);
}

