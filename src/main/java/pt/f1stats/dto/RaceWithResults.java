package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RaceWithResults(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("raceName") String raceName,
        @JsonProperty("Circuit") Circuit circuit,
        @JsonProperty("date") String date,
        @JsonProperty("time") String time,
        @JsonProperty("Results") List<Result> results
) {
}