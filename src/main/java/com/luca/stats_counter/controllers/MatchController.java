package com.luca.stats_counter.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.services.matchServices.CreateMatchService;
import com.luca.stats_counter.services.matchServices.DeleteMatchService;
import com.luca.stats_counter.services.matchServices.GetAllMatchesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/match")
public class MatchController {
    

    private final GetAllMatchesService getAllMatchesService;
    private final DeleteMatchService deleteMatchService;
    private final CreateMatchService createMatchService;

    public MatchController(GetAllMatchesService getAllMatchesService, DeleteMatchService deleteMatchService, CreateMatchService createMatchService){
        this.getAllMatchesService = getAllMatchesService;
        this.deleteMatchService = deleteMatchService;
        this.createMatchService = createMatchService;
    }//Immutable DI

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches(){
        return getAllMatchesService.execute(null);
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
     return createMatchService.execute(match);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id){
        return deleteMatchService.execute(id);
    }


}
