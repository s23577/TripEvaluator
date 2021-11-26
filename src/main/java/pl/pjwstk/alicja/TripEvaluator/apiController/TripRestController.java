package pl.pjwstk.alicja.TripEvaluator.apiController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pjwstk.alicja.TripEvaluator.models.Review;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;
import pl.pjwstk.alicja.TripEvaluator.service.ReviewService;
import pl.pjwstk.alicja.TripEvaluator.service.TripService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripRestController {

    //wstrzykujemy zaleznosc - pole i konstruktor
    private TripService tripService;
    public TripRestController(TripService tripService){
        this.tripService = tripService;
    }
    private ReviewService reviewService;
    public TripRestController(ReviewService reviewService) {this.reviewService = reviewService; }
    @GetMapping("/favourite")
    public ResponseEntity<Trip> example1(){
        return ResponseEntity.ok(tripService.buildExampleOfTrip());
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Trip>> getAll(){
        return ResponseEntity.ok(tripService.listOfTrips());
    }

    //http://localhost:8080/getTripById/2   <- 2 to id
    @GetMapping("/findTripId")
    public ResponseEntity getTripById(@PathVariable Integer id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }
    //trip ma listReview, a każde review ma autora
    @PostMapping(path = "/save")
    public ResponseEntity addNewTrip(@RequestBody Trip trip){
        tripService.save(trip);

        //ponizszy fragment kodu pozwala na wyszukanie pozniej trip po id
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/trip/findTripId")
                .path("/{id}")
                .buildAndExpand(trip.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    //review majace autora
    @PostMapping(path = "/addReview")
    public ResponseEntity addNewReview(@RequestBody Review review){
        //sprawdzam, czy istnieje autorUser dla review
        Optional<Integer> authorUserId = Optional.ofNullable(review.getAuthorUser().getId());
        if(authorUserId.isPresent()){
           reviewService.addReview(review);
        } else {
            return ResponseEntity.ok("Author doesn't exist, try again!!!");
        }
        return ResponseEntity.ok("The trip was successfully saved to database.");
    }
    //usuwanie trip po id
    @DeleteMapping("/deleteTrip/{id}")
    public ResponseEntity<?> deleteTripById(@PathVariable Integer id){
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }
    //usuwanie rewiev po id
    @DeleteMapping("/DeleteReview/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Integer id){
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
