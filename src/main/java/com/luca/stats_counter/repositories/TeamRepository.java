package com.luca.stats_counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.stats_counter.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
