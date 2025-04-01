package com.luca.stats_counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.models.Statistics;
import java.util.List;


public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    List<Statistics> findByMatch(Match match);
}
