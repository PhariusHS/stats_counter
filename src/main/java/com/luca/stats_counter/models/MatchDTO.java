package com.luca.stats_counter.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MatchDTO {
    
    private Long id;
    private LocalDate localDate;
    private Long round;
    private Team localTeam;
    private Team visitantTeam;

    public MatchDTO(Match match){
        this.id = match.getId();
        this.localDate = match.getLocalDate();
        this.round = match.getRound();
        this.localTeam = match.getLocalTeam();
        this.visitantTeam = match.getVisitantTeam();
    }
}
