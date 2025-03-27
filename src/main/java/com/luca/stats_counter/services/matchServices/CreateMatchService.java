package com.luca.stats_counter.services.matchServices;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.repositories.MatchRepository;
import com.luca.stats_counter.repositories.StatisticsRepository;

@Service
public class CreateMatchService implements Command<Match, Match> {


    private final MatchRepository matchRepository;
    private final StatisticsRepository statisticsRepository;
    public CreateMatchService(MatchRepository matchRepository, StatisticsRepository statisticsRepository){
        this.matchRepository = matchRepository;
        this.statisticsRepository = statisticsRepository;
    } // Immutable DI;

    @Override
    public ResponseEntity<Match> execute(Match match) {
        Match savedMatch = matchRepository.save(match);
        for (int i = 0; i < 2; i++){
            Statistics stats = new Statistics();
            stats.setMatch(savedMatch);
            if(i == 1){
                stats.setTeam(savedMatch.getLocalTeam());
                stats.setIsLocal(true);
            } else {
                stats.setTeam(savedMatch.getVisitantTeam());
                stats.setIsLocal(false);
            }
            statisticsRepository.save(stats);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatch);
    }
    
}
