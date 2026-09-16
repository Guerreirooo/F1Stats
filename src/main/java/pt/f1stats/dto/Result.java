package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Result(
        @JsonProperty("number") String number,
        @JsonProperty("position") String position,
        @JsonProperty("positionText") String positionText,
        @JsonProperty("points") String points,
        @JsonProperty("Driver") Driver driver,
        @JsonProperty("Constructor") Constructor constructor,
        @JsonProperty("grid") String grid,
        @JsonProperty("laps") String laps,
        @JsonProperty("status") String status,
        @JsonProperty("Time") RaceTime time,
        @JsonProperty("FastestLap") FastestLap fastestLap
) {
}