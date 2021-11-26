package pl.pjwstk.alicja.TripEvaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjwstk.alicja.TripEvaluator.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository <Review, Integer>{
}
