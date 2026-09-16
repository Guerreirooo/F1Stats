package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RaceScheduleResponse(
        @JsonProperty("MRData") MRData mrData
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MRData(
            @JsonProperty("RaceTable") RaceTable raceTable
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record RaceTable(
            @JsonProperty("Races") List<Race> races
    ) {
    }
}