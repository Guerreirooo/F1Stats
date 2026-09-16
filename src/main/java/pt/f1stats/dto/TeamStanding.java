package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TeamStanding(
        @JsonProperty("position") String position,
        @JsonProperty("points") String points,
        @JsonProperty("wins") String wins,
        @JsonProperty("Constructor") Constructor constructor
) {
}
