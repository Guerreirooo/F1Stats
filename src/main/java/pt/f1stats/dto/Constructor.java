package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Constructor(
        @JsonProperty("constructorId") String constructorId,
        @JsonProperty("name") String name,
        @JsonProperty("nationality") String nationality
) {
}