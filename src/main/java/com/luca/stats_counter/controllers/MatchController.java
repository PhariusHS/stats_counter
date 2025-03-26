package com.luca.stats_counter.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.services.matchServices.GetAllMatchesService;

@RestController
@RequestMapping("/match")
public class MatchController {
    

    private final GetAllMatchesService getAllMatchesService;

    public MatchController(GetAllMatchesService getAllMatchesService){
        this.getAllMatchesService = getAllMatchesService;
    }//Immutable DI

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches(){
        return getAllMatchesService.execute(null);
    }




}
