package com.luca.stats_counter.services.matchServices;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luca.stats_counter.Command;
import com.luca.stats_counter.RelationalCommand;
import com.luca.stats_counter.models.Match;
import com.luca.stats_counter.models.MatchDTO;
import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.models.Team;
import com.luca.stats_counter.repositories.MatchRepository;
import com.luca.stats_counter.repositories.StatisticsRepository;
import com.luca.stats_counter.repositories.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CreateMatchService implements RelationalCommand<Match, MatchDTO, Long> {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final StatisticsRepository statisticsRepository;

    public CreateMatchService(MatchRepository matchRepository, StatisticsRepository statisticsRepository,
            TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.statisticsRepository = statisticsRepository;
        this.teamRepository = teamRepository;
    } // Immutable DI;

    @Override
    public ResponseEntity<MatchDTO> execute(Match match, Long localTeamId, Long visitantTeamId) {

        Optional<Team> foundedLocalTeam = teamRepository.findById(localTeamId);
        Optional<Team> foundedVisitantTeam = teamRepository.findById(visitantTeamId);

        if (!foundedLocalTeam.isPresent()) {
            throw new EntityNotFoundException();
        }
        if (!foundedVisitantTeam.isPresent()) {
            throw new EntityNotFoundException();
        } // todo handling error

        match.setLocalTeam(foundedLocalTeam.get());
        match.setVisitantTeam(foundedVisitantTeam.get());
        Match savedMatch = matchRepository.save(match);
        for (int i = 0; i < 2; i++) { // For every match are two statistics objects, one per team
            Statistics stats = new Statistics();
            stats.setMatch(savedMatch);
            if (i == 1) { // set the local team
                stats.setTeam(savedMatch.getLocalTeam());
                stats.setIsLocal(true);
            } else { // set the visitant team
                stats.setTeam(savedMatch.getVisitantTeam());
                stats.setIsLocal(false);
            }
            statisticsRepository.save(stats);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new MatchDTO(savedMatch));
    }

}
