package com.luca.stats_counter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.models.TeamDTO;
import com.luca.stats_counter.services.teamServices.CreateTeamService;
import com.luca.stats_counter.services.teamServices.DeleteTeamService;
import com.luca.stats_counter.services.teamServices.GetAllTeamsService;
import com.luca.stats_counter.services.teamServices.GetTeamByIdService;
import com.luca.stats_counter.services.teamServices.UpdateTeamCommand;
import com.luca.stats_counter.services.teamServices.UpdateTeamService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/team")
public class TeamController {

    private final GetAllTeamsService getAllTeamsService;
    private final CreateTeamService createTeamService;
    private final GetTeamByIdService getTeamByIdService;
    private final DeleteTeamService deleteTeamService;
    private final UpdateTeamService updateTeamService;

    public TeamController(GetAllTeamsService getAllTeamsService, CreateTeamService createTeamService,
            GetTeamByIdService getTeamByIdService,
            DeleteTeamService deleteTeamService,
            UpdateTeamService updateTeamService) {
        this.getAllTeamsService = getAllTeamsService;
        this.createTeamService = createTeamService;
        this.getTeamByIdService = getTeamByIdService;
        this.deleteTeamService = deleteTeamService;
        this.updateTeamService = updateTeamService;
    }// Immutable DI

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return getAllTeamsService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        return getTeamByIdService.execute(id);
    }
    
    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody Team team) {
        return createTeamService.execute(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
      return updateTeamService.execute(new UpdateTeamCommand(id, teamDetails));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id){
        return deleteTeamService.execute(id);
    }

    

}
