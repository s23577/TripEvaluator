package pl.pjwstk.alicja.TripEvaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}