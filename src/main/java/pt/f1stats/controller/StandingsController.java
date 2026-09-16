package pt.f1stats.controller;

import pt.f1stats.dto.TeamStanding;
import pt.f1stats.dto.DriverStanding;
import pt.f1stats.service.StandingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standings")
public class StandingsController {

    private final StandingsService standingsService;

    public StandingsController(StandingsService standingsService) {
        this.standingsService = standingsService;
    }

    @GetMapping("/drivers")
    public List<DriverStanding> getDriverStandings() {
        return standingsService.getCurrentDriverStandings();
    }

    @GetMapping("/constructors")
    public List<TeamStanding> getConstructorStandings() {
        return standingsService.getCurrentConstructorStandings();
    }

}