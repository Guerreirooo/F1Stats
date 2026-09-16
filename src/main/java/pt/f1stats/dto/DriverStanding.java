package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DriverStanding(
        @JsonProperty("position") String position,
        @JsonProperty("points") String points,
        @JsonProperty("wins") String wins,
        @JsonProperty("Driver") Driver driver,
        @JsonProperty("Constructors") List<Constructor> constructors
) {
}
