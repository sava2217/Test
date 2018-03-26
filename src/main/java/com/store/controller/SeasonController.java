package com.store.controller;

import com.store.entity.Season;
import com.store.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/season")
public class SeasonController {

    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }


    @GetMapping
    public Iterable<Season> show() {
        return seasonService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Season> findSeason(@PathVariable Long id){
        return seasonService.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeason(@PathVariable Long id){
        seasonService.delete(id);
    }
}
