package pl.pjwstk.alicja.TripEvaluator.service;

import pl.pjwstk.alicja.TripEvaluator.models.AuthorUser;
import pl.pjwstk.alicja.TripEvaluator.models.MainTypeOfConveyance;
import pl.pjwstk.alicja.TripEvaluator.models.Review;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;
import pl.pjwstk.alicja.TripEvaluator.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class TripService {
    private final TripRepository tripRepository;
    public TripService(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }
    public Trip createTrip(){
        AuthorUser author1 = new AuthorUser(null, "JEDREK",16, true);
        List<Review> reviews = new ArrayList<>();
        Review review = new Review(null, "mushrooms", author1, 1);
        reviews.add(review);
        Trip trip1 = new Trip(null, "Sandplace", "SAHARA", 50, 500, MainTypeOfConveyance.BIKE, reviews);
        return tripRepository.save(trip1);
    }
    public Trip addReview(Integer tripId){
        Trip trip = this.tripRepository.getById(tripId);
        AuthorUser authorUser = new AuthorUser(null, "MAX", 3, true);
        Review review = new Review(null, "best trip", authorUser, 5);
        trip.addToReviewList(review);
        return tripRepository.save(trip);
        }
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }
    public Trip getTripById(Integer id){
        return tripRepository.findById(id).orElseGet(() -> null); //jesli nie znajdzie to null
    }
    public void deleteTripById(Integer id){
        tripRepository.deleteById(id);
    }
}