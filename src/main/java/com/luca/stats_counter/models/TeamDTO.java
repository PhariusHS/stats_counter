package com.luca.stats_counter.models;

import java.util.List;

import lombok.Data;

@Data
public class TeamDTO {

    private Long id;
    private String name;
    private String location;
    private List<Match> teamMatchesAsLocal;
    private List<Match> teamMatchesAsVisitant;


    public TeamDTO(Team team){
        this.id = team.getId();
        this.name = team.getName();
        this.location = team.getLocation();
        this.teamMatchesAsLocal = team.getTeamMatchesAsLocal();
        this.teamMatchesAsVisitant = team.getTeamMatchesAsVisitant();
    }

}
