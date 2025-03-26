package com.luca.stats_counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.stats_counter.models.Match;

public interface MatchRepository extends JpaRepository<Match, Long>  {
    
}
