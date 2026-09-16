package pt.f1stats.service;

import pt.f1stats.client.Client;
import pt.f1stats.dto.TeamStanding;
import pt.f1stats.dto.DriverStanding;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StandingsService {

    private final Client client;

    public StandingsService(Client jolpicaClient) {
        this.client = jolpicaClient;
    }

    public List<DriverStanding> getCurrentDriverStandings() {
        var response = client.getCurrentDriverStandings();

        var standingsLists = response.mrData().standingsTable().standingsLists();
        if (standingsLists.isEmpty()) {
            return Collections.emptyList();
        }

        // A API devolve sempre uma única lista dentro de StandingsLists para "current"
        return standingsLists.get(0).driverStandings();
    }

    public List<TeamStanding> getCurrentConstructorStandings() {
        var response = client.getCurrentConstructorStandings();

        var standingsLists = response.mrData().standingsTable().standingsLists();
        if (standingsLists.isEmpty()) {
            return Collections.emptyList();
        }

        return standingsLists.get(0).constructorStandings();
    }

}