package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FastestLap(
        @JsonProperty("rank") String rank,
        @JsonProperty("lap") String lap,
        @JsonProperty("Time") RaceTime time,
        @JsonProperty("AverageSpeed") AverageSpeed averageSpeed
) {
}