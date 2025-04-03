package com.luca.stats_counter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference(value = "team_statistics_reference")
    @ManyToOne
    private Team team;

    private Boolean isLocal;

    @JsonBackReference(value = "match_statistics_reference")
    @ManyToOne
    private Match match;

    private Integer score;
    private Integer penaltiesConceded;
    private Integer handlingErrors;
    private Integer winnedScrums;
    private Integer losedScrums;
    private Integer winnedLines;
    private Integer losedLines;
    private Integer fiftyTwentytwo;
    private Integer trys;
    private Integer conversions;
    private Integer penaltieGoal;
    private Integer failedPenaltieGoal;

}
