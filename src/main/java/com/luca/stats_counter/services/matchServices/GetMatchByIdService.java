package com.luca.stats_counter.services.matchServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.luca.stats_counter.Query;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.models.MatchDTO;
import com.luca.stats_counter.repositories.MatchRepository;

import jakarta.persistence.EntityNotFoundException;

public class GetMatchByIdService implements Query<Long, MatchDTO>{

    private final MatchRepository matchRepository;

    public GetMatchByIdService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    } // Immutable DI

    @Override
    public ResponseEntity<MatchDTO> execute(Long id) {
        Optional<Match> foundedMatch = matchRepository.findById(id);
        if(foundedMatch.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new MatchDTO(foundedMatch.get()));
        }
        throw new EntityNotFoundException();
    }
}
