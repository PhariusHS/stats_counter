package com.luca.stats_counter.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @JsonIgnore
    @JsonManagedReference(value = "team_statistics_reference")
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Statistics> teamStatistics;

    @JsonManagedReference(value = "local_team_reference")
    @OneToMany(mappedBy = "localTeam", cascade = CascadeType.ALL)
    private List<Match> teamMatchesAsLocal;

    @JsonManagedReference(value = "visitant_team_reference")
    @OneToMany(mappedBy = "visitantTeam", cascade = CascadeType.ALL)
    private List<Match> teamMatchesAsVisitant;

}
