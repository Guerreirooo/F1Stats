package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Location(
        @JsonProperty("lat") String lat,
        @JsonProperty("long") String longitude,
        @JsonProperty("locality") String locality,
        @JsonProperty("country") String country
) {
}