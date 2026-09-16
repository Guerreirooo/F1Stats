package pt.f1stats.service;

import pt.f1stats.client.Client;
import pt.f1stats.dto.Race;
import pt.f1stats.dto.RaceWithResults;
import pt.f1stats.entity.CachedRace;
import pt.f1stats.repository.CachedRaceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private static final String SCHEDULE_TYPE = "SCHEDULE";
    private static final String RESULTS_TYPE = "RESULTS";
    private static final String ALL_ROUNDS = "ALL";

    private final Client client;
    private final CachedRaceRepository cachedRaceRepository;
    private final ObjectMapper objectMapper;

    public RaceService(Client client,
                       CachedRaceRepository cachedRaceRepository,
                       ObjectMapper objectMapper) {
        this.client = client;
        this.cachedRaceRepository = cachedRaceRepository;
        this.objectMapper = objectMapper;
    }

    public List<Race> getRaces(String season) {
        Optional<CachedRace> cached = cachedRaceRepository
                .findBySeasonAndRoundAndEndpointType(season, ALL_ROUNDS, SCHEDULE_TYPE);

        if (cached.isPresent()) {
            return deserializeList(cached.get().getRawJson(), Race.class);
        }

        var response = client.getRaces(season);
        List<Race> races = response.mrData().raceTable().races();

        cachedRaceRepository.save(new CachedRace(season, ALL_ROUNDS, SCHEDULE_TYPE, serialize(races)));

        return races;
    }

    public Optional<RaceWithResults> getRaceResults(String season, String round) {
        Optional<CachedRace> cached = cachedRaceRepository
                .findBySeasonAndRoundAndEndpointType(season, round, RESULTS_TYPE);

        if (cached.isPresent()) {
            return Optional.ofNullable(deserializeSingle(cached.get().getRawJson(), RaceWithResults.class));
        }

        var response = client.getRaceResults(season, round);
        List<RaceWithResults> races = response.mrData().raceTable().races();

        if (races.isEmpty()) {
            return Optional.empty();
        }

        RaceWithResults race = races.get(0);
        cachedRaceRepository.save(new CachedRace(season, round, RESULTS_TYPE, serialize(race)));

        return Optional.of(race);
    }

    private String serialize(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Erro ao converter dados para JSON de cache", e);
        }
    }

    private <T> List<T> deserializeList(String json, Class<T> type) {
        try {
            return objectMapper.readValue(
                    json,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, type)
            );
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Erro ao ler dados em cache", e);
        }
    }

    private <T> T deserializeSingle(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Erro ao ler dados em cache", e);
        }
    }

}