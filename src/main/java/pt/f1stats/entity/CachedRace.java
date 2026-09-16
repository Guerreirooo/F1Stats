package pt.f1stats.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.Instant;

@Entity
@Table(
        name = "cached_races",
        uniqueConstraints = @UniqueConstraint(columnNames = {"season", "round", "endpoint_type"})
)
public class CachedRace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String season;

    // "ALL" quando é o calendário completo da temporada (sem round específico)
    @Column(nullable = false)
    private String round;

    // "SCHEDULE" (calendário) ou "RESULTS" (resultados de uma corrida)
    @Column(name = "endpoint_type", nullable = false)
    private String endpointType;

    @Lob
    @Column(nullable = false)
    private String rawJson;

    @Column(nullable = false)
    private Instant cachedAt;

    protected CachedRace() {}

    public CachedRace(String season, String round, String endpointType, String rawJson) {
        this.season = season;
        this.round = round;
        this.endpointType = endpointType;
        this.rawJson = rawJson;
        this.cachedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    public String getEndpointType() {
        return endpointType;
    }

    public String getRawJson() {
        return rawJson;
    }

    public Instant getCachedAt() {
        return cachedAt;
    }

    public void updateData(String rawJson) {
        this.rawJson = rawJson;
        this.cachedAt = Instant.now();
    }

}