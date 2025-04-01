package com.luca.stats_counter.services.statisticsServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Query;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.repositories.MatchRepository;
import com.luca.stats_counter.repositories.StatisticsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GetStatistcsByMatchService implements Query<Long, List<Statistics>> {

    private final StatisticsRepository statisticsRepository;
    private final MatchRepository matchRepository;
    public GetStatistcsByMatchService(StatisticsRepository statisticsRepository, MatchRepository matchRepository){
        this.statisticsRepository = statisticsRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public ResponseEntity<List<Statistics>> execute(Long id) {
        
        Optional<Match> foundedMatch = matchRepository.findById(id);
        if(foundedMatch.isPresent()){
            List<Statistics> matchStatistics = statisticsRepository.findByMatch(foundedMatch.get());
            return ResponseEntity.status(HttpStatus.OK).body(matchStatistics);
        }
        throw new EntityNotFoundException();
    }

}
