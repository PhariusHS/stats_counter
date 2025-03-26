package com.luca.stats_counter.services.matchServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.repositories.MatchRepository;

@Service
public class GetAllMatchesService implements Command<Void, List<Match>> {

    private final MatchRepository matchRepository;
    public GetAllMatchesService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    } // Immutable DI;

    @Override
    public ResponseEntity<List<Match>> execute(Void input) {
        List<Match> foundedMatches = matchRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(foundedMatches);
    } // If there's no matches just return an empty list
    
}
