package com.luca.stats_counter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull
    private Boolean isLocal;

    @JsonBackReference(value = "match_statistics_reference")
    @ManyToOne
    private Match match;

    @NotNull
    @Positive
    private Integer score;
    @NotNull
    @Positive
    private Integer penaltiesConceded;
    @NotNull
    @Positive
    private Integer handlingErrors;
    @NotNull
    @Positive
    private Integer winnedScrums;
    @NotNull
    @Positive
    private Integer losedScrums;
    @NotNull
    @Positive
    private Integer winnedLines;
    @NotNull
    @Positive
    private Integer losedLines;
    @NotNull
    @Positive
    private Integer fiftyTwentytwo;
    @NotNull
    @Positive
    private Integer trys;
    @NotNull
    @Positive
    private Integer conversions;
    @NotNull
    @Positive
    private Integer penaltieGoal;
    @NotNull
    @Positive
    private Integer failedPenaltieGoal;

}
