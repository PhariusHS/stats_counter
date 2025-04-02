package com.luca.stats_counter.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JsonManagedReference(value = "match_statistics_reference")
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER )
    private List<Statistics> matchStatistics;

    
    @JsonBackReference(value = "local_team_reference")
    @ManyToOne
    private Team localTeam;

    @JsonBackReference(value  = "visitant_team_reference")
    @ManyToOne
    private Team visitantTeam;

}
