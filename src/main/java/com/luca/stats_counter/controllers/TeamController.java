package com.luca.stats_counter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.services.teamServices.GetAllTeamsService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/team")
public class TeamController {

    private final GetAllTeamsService getAllTeamsService;
    public TeamController(GetAllTeamsService getAllTeamsService) {
        this.getAllTeamsService = getAllTeamsService;
    }// Immutable DI

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return getAllTeamsService.execute(null);
    }
    


}
