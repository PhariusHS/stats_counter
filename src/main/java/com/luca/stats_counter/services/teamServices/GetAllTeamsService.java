package com.luca.stats_counter.services.teamServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Query;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.repositories.TeamRepository;

@Service
public class GetAllTeamsService implements Query<Void, List<Team>> {

    private final TeamRepository teamRepository;
    public GetAllTeamsService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }// Immutable DI;
    @Override
    public ResponseEntity<List<Team>> execute(Void input) {
        List<Team> foundedTeams = teamRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(foundedTeams);
    }// If there's no teams just return an empty list
}
