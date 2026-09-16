package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Race(
        @JsonProperty("season") String season,
        @JsonProperty("round") String round,
        @JsonProperty("raceName") String raceName,
        @JsonProperty("Circuit") Circuit circuit,
        @JsonProperty("date") String date,
        @JsonProperty("time") String time
) {
}