package pl.pjwstk.alicja.TripEvaluator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.alicja.TripEvaluator.models.Review;
import pl.pjwstk.alicja.TripEvaluator.repository.ReviewRepository;

@Service
public class ReviewService {
    //wstrzykniecie repozytorium do serwisu poprzez konstruktor serwisu
    private static ReviewRepository reviewRepository;
    @Autowired
    private ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    //addReview
    public void addReview(Review review){
        reviewRepository.save(review);
    }
    //delete review
    public void deleteReview(Integer id){
        reviewRepository.deleteById(id);
    }
}
