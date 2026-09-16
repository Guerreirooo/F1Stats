package pt.f1stats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Driver(
        @JsonProperty("driverId") String driverId,
        @JsonProperty("code") String code,
        @JsonProperty("permanentNumber") String permanentNumber,
        @JsonProperty("givenName") String givenName,
        @JsonProperty("familyName") String familyName,
        @JsonProperty("nationality") String nationality
) {
}