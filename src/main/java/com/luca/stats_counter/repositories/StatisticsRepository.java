package com.luca.stats_counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.stats_counter.models.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    
}
