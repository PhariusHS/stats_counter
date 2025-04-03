package com.luca.stats_counter.services.teamServices;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.models.TeamDTO;
import com.luca.stats_counter.repositories.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UpdateTeamService implements Command<UpdateTeamCommand, TeamDTO> {

    private final TeamRepository teamRepository;
    public UpdateTeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }// Immutable DI;
    @Override
    public ResponseEntity<TeamDTO> execute(UpdateTeamCommand command) {
        Optional<Team> foundedTeam = teamRepository.findById(command.getId());
        if(foundedTeam.isPresent()){
            Team existingTeam = command.getTeam();//get the updated product
            existingTeam.setId(command.getId());
            Team updatedTeam = teamRepository.save(existingTeam); // saving the new product
            return ResponseEntity.status(HttpStatus.OK).body(new TeamDTO(updatedTeam));
        }
        throw new EntityNotFoundException();
    }

    
  
    
}
