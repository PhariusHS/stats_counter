package com.luca.stats_counter.services.teamServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.repositories.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteTeamService implements Command<Long, Void> {
    
     private final TeamRepository teamRepository;
    public DeleteTeamService (TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }//Immutable DI
    
    @Override
    public ResponseEntity<Void> execute(Long id) {
        Optional<Team> foundedTeam = teamRepository.findById(id);
        if(foundedTeam.isPresent()){
            teamRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException();
    }
}
