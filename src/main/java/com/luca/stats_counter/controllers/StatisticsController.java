package com.luca.stats_counter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.services.statisticsServices.GetStatisticsByMatchService;
import com.luca.stats_counter.services.statisticsServices.GetStatisticsByTeamService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/stats")
public class StatisticsController  {
    
    private final GetStatisticsByMatchService getStatisticsByMatchService;
    private final GetStatisticsByTeamService getStatisticsByTeamService;

    public StatisticsController(GetStatisticsByMatchService getStatisticsByMatchService, GetStatisticsByTeamService getStatisticsByTeamService){
        this.getStatisticsByMatchService = getStatisticsByMatchService;
        this.getStatisticsByTeamService = getStatisticsByTeamService;
    }
    @GetMapping("/per-match")
    public ResponseEntity<List<Statistics>> getStatsByMatch(@RequestParam Long matchId) {
        return getStatisticsByMatchService.execute(matchId);
    }
    @GetMapping("/per-team")
    public ResponseEntity<List<Statistics>> getStatsByTeam(@RequestParam Long teamId) {
        return getStatisticsByTeamService.execute(teamId);
    }
}
