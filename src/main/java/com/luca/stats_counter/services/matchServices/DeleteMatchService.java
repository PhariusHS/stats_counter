package com.luca.stats_counter.services.matchServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.repositories.MatchRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteMatchService implements Command<Long, Void>{

    private final MatchRepository matchRepository;
    public DeleteMatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    } // Immutable DI;

    @Override
    public ResponseEntity<Void> execute(Long matchId) {
        Optional<Match> foundedMatch = matchRepository.findById(matchId);
        if(foundedMatch.isPresent()){//Verifies if the match exists
            matchRepository.deleteById(matchId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException(); //todo exception
    }
    
}
