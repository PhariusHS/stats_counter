package com.luca.stats_counter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.stats_counter.models.Statistics;
import com.luca.stats_counter.services.statisticsServices.GetStatistcsByMatchService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/stats")
public class StatisticsController  {
    
    private final GetStatistcsByMatchService getStatistcsByMatchService;

    public StatisticsController(GetStatistcsByMatchService getStatistcsByMatchService){
        this.getStatistcsByMatchService = getStatistcsByMatchService;
    }


    @GetMapping("/per-match")
    public ResponseEntity<List<Statistics>> getStatsByMatch(@RequestParam Long matchId) {
        return getStatistcsByMatchService.execute(matchId);
    }
    



}
