package com.luca.stats_counter.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game_match")
public class Match {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) 
    private Long id;

    private LocalDate localDate;

    private Long round;

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<Statistics> matchStatistics;

   
    @ManyToOne
    private Team localTeam;

    
    @ManyToOne
    private Team visitantTeam;

}
