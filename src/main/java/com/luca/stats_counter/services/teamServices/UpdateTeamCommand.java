package com.luca.stats_counter.services.teamServices;

import com.luca.stats_counter.models.Team;

import lombok.Data;

@Data
public class UpdateTeamCommand {
private Long id;
private Team team;
public  UpdateTeamCommand(Long id, Team team){
    this.id = id;
    this.team = team;
}
}
