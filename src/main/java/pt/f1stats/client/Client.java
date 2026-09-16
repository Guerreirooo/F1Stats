package pt.f1stats.client;

import pt.f1stats.dto.TeamStandingResponse;
import pt.f1stats.dto.DriverStandingResponse;
import pt.f1stats.dto.RaceScheduleResponse;
import pt.f1stats.dto.RaceResultsResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class Client {

    private final RestClient restClient;

    public Client(RestClient jolpicaRestClient) {
        this.restClient = jolpicaRestClient;
    }

    /**
     * Classificação atual de pilotos.
     * Endpoint: GET /current/driverStandings.json
     */
    public DriverStandingResponse getCurrentDriverStandings() {
        return restClient.get()
                .uri("/current/driverStandings.json")
                .retrieve()
                .body(DriverStandingResponse.class);
    }

    /**
     * Classificação atual de equipas.
     * Endpoint: GET /current/constructorStandings.json
     */
    public TeamStandingResponse getCurrentConstructorStandings() {
        return restClient.get()
                .uri("/current/constructorStandings.json")
                .retrieve()
                .body(TeamStandingResponse.class);
    }

    /**
     * Vai buscar o calendário completo de uma temporada (sem resultados).
     * Endpoint real: GET /{season}/races.json
     */
    public RaceScheduleResponse getRaces(String season) {
        return restClient.get()
                .uri("/{season}/races.json", season)
                .retrieve()
                .body(RaceScheduleResponse.class);
    }

    /**
     * Vai buscar os resultados de uma corrida específica.
     * Endpoint real: GET /{season}/{round}/results.json
     */
    public RaceResultsResponse getRaceResults(String season, String round) {
        return restClient.get()
                .uri("/{season}/{round}/results.json", season, round)
                .retrieve()
                .body(RaceResultsResponse.class);
    }

}