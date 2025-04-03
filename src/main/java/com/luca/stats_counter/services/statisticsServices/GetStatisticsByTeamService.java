package com.luca.stats_counter.services.statisticsServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Query;
import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.repositories.StatisticsRepository;
import com.luca.stats_counter.repositories.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GetStatisticsByTeamService implements Query<Long, List<Statistics>> {
    

    private final StatisticsRepository statisticsRepository;
    private final TeamRepository teamRepository;
    public GetStatisticsByTeamService (StatisticsRepository statisticsRepository, TeamRepository teamRepository){
        this.statisticsRepository = statisticsRepository;
        this.teamRepository = teamRepository;
    } // Immutable DI
    @Override
    public ResponseEntity<List<Statistics>> execute(Long teamId) {
        Optional<Team> foundedTeam = teamRepository.findById(teamId);
        if(foundedTeam.isPresent()){
            List<Statistics> teamStatistics = statisticsRepository.findByTeam(foundedTeam.get());
            return ResponseEntity.status(HttpStatus.OK).body(teamStatistics);
        }
        throw new EntityNotFoundException();
    }
}
