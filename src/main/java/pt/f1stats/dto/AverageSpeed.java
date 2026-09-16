package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AverageSpeed(
        @JsonProperty("units") String units,
        @JsonProperty("speed") String speed
) {
}