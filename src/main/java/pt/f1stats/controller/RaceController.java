package pt.f1stats.controller;

import pt.f1stats.dto.Race;
import pt.f1stats.dto.RaceWithResults;
import pt.f1stats.service.RaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/{season}")
    public List<Race> getRaces(@PathVariable String season) {
        return raceService.getRaces(season);
    }

    @GetMapping("/{season}/{round}")
    public ResponseEntity<RaceWithResults> getRaceResults(@PathVariable String season, @PathVariable String round) {
        return raceService.getRaceResults(season, round)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}