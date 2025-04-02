package com.luca.stats_counter.services.matchServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.repositories.MatchRepository;
import com.luca.stats_counter.repositories.StatisticsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteMatchService implements Command<Long, Void>{

    private final MatchRepository matchRepository;
    private final StatisticsRepository statisticsRepository;
    public DeleteMatchService(MatchRepository matchRepository, StatisticsRepository statisticsRepository){
        this.matchRepository = matchRepository;
        this.statisticsRepository = statisticsRepository;
    } // Immutable DI;

    @Override
    public ResponseEntity<Void> execute(Long matchId) {
        Optional<Match> foundedMatch = matchRepository.findById(matchId);
        if(foundedMatch.isPresent()){//Verifies if the match exists
            List<Statistics> matchStatistics = statisticsRepository.findByMatch(foundedMatch.get());
            for(Statistics i : matchStatistics){
                statisticsRepository.deleteById(i.getId());
            } // delete statistics before deleting the Match
            
            matchRepository.deleteById(matchId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException(); //todo exception
    }
    
}
