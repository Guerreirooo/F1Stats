package pt.f1stats.repository;

import pt.f1stats.entity.CachedRace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CachedRaceRepository extends JpaRepository<CachedRace, Long> {

    Optional<CachedRace> findBySeasonAndRoundAndEndpointType(
            String season,
            String round,
            String endpointType
    );

}