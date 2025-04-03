package com.luca.stats_counter.services.teamServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Query;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.models.TeamDTO;
import com.luca.stats_counter.repositories.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GetTeamByIdService implements Query<Long, TeamDTO> {
    private final TeamRepository teamRepository;
    public GetTeamByIdService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }// Immutable DI;
    @Override
    public ResponseEntity<TeamDTO> execute(Long id) {
        Optional<Team> foundedTeam = teamRepository.findById(id);
        if (foundedTeam.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new TeamDTO(foundedTeam.get()));
        }
        throw new EntityNotFoundException();
    }
}
