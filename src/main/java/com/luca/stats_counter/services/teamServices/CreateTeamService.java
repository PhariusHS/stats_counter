package com.luca.stats_counter.services.teamServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.models.TeamDTO;
import com.luca.stats_counter.repositories.TeamRepository;

@Service
public class CreateTeamService implements Command<Team, TeamDTO> {

    private final TeamRepository teamRepository;
    public CreateTeamService (TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }//Immutable DI
    @Override
    public ResponseEntity<TeamDTO> execute(Team team) {
        Team savedTeam = teamRepository.save(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TeamDTO(savedTeam));
    }
}
