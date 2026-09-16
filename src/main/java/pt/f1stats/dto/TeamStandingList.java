package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TeamStandingList(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("ConstructorStandings") List<TeamStanding> constructorStandings
) {
}