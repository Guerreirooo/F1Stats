package pt.f1stats.client;

import pt.f1stats.dto.TeamStandingResponse;
import pt.f1stats.dto.DriverStandingResponse;
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

}