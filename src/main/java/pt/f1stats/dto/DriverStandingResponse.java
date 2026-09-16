package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DriverStandingResponse(
        @JsonProperty("MRData") MRData mrData
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MRData(
            @JsonProperty("StandingsTable") StandingsTable standingsTable
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record StandingsTable(
            @JsonProperty("StandingsLists") List<DriverStandingList> standingsLists
    ) {
    }
}