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

    //1
    public void addSuffixToTrip(Trip trip){
        if(trip.getTitle() == null || trip.getTitle().isBlank()){
            trip.setTitle("WOW");
        } else {
            trip.setTitle((trip.getTitle() + "_SUFFIX"));
        }
    }
    //2
    public void addReviewWithoutSave(Trip trip, Review review){
        if(trip.getReviewList() != null){
            trip.getReviewList().add(review);
        }
    }
    //3
    public boolean isFullyReviewedTrip(Trip trip){
        return trip.getReviewList().size() >=10;
    }
    //4
    public String isTripLong(Trip trip){
        if(trip.getDaysOfDuration() >=14){
            return "This Trip is Long";
        } else if(trip.getDaysOfDuration() <=3){
            return "This Trip is Short";
        } else {
            return "Your trip is normal Duration";
        }
    }
    //5
    public String isTripExpensive(Trip trip){
        if(trip.getCommission() > 1000){
            return "This Trip " + trip.getTitle() + "is expensive";
        } else{
            return "This Trip " + trip.getTitle() + "is not expensive";
        }
    }
    //6
    public boolean isTripWithAirplane(Trip trip){
        if(trip.getMainTypeOfConveyance() == MainTypeOfConveyance.AIRPLANE){
            return true;
        } else {
            return false;
        }
    }
    //7
    public boolean isDestinationSpain(Trip trip){
        if(trip.getDestination().equals("Spain")){
            return true;
        } else {
            return false;
        }
    }
    //8
    public double costOfTwoTrips(Trip trip1, Trip trip2){
        double costs;
        costs = trip1.getCommission() + trip2.getCommission();
        return costs;
    }
    //9
    public String hasTripTwoReviews(Trip trip){
        if(trip.getReviewList().size() == 2){
            return "Trip has 2 reviews.";
        }
        return "Trip has not 2 reviews.";
    }
    //10
    public boolean isTripIdHigherThan50(Trip trip){
        if(trip.getId() > 50){
            return true;
        } else {
            return false;
        }
    }
}