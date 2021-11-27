package pl.pjwstk.alicja.TripEvaluator.apiController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;
import pl.pjwstk.alicja.TripEvaluator.service.TripService;
import java.util.List;


@RestController
@RequestMapping("/trip")
public class TripRestController {
    private final TripService tripService;

    public TripRestController(TripService tripService){
        this.tripService = tripService;
    }
    //save - zapisuje nową wycieczkę, która ma listę review. Każde review ma autora
    @RequestMapping("/addTrip")
    public ResponseEntity<Trip> addTrip(){
        Trip trip = tripService.createTrip();
        return ResponseEntity.ok(trip);

    }
    //addReview - dodaje review (które ma autora) do istniejącej wycieczki
    @RequestMapping("/addReview")
    public ResponseEntity addReview() {
        return ResponseEntity.ok(tripService.addReview(1));
    }
    //findAll - zwraca wszystkie wycieczki
    @RequestMapping("/getAllTrips")
    public ResponseEntity<List<Trip>> getAllTrips(){
        return ResponseEntity.ok(tripService.getAllTrips());
    }
    //findById - parametr ID ma być przyjęty z adresu i przekazany dalej
    //http://localhost:8080/findTripById/2   <- 2 to id
    @GetMapping("/findTripById/{id}")
    public ResponseEntity getTripById(@PathVariable Integer id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }
    //delete - parametr ID ma być przyjęty z adresu i przekazany dalej
    @GetMapping("/deleteTripById/{id}")
    public ResponseEntity deleteTripById(@PathVariable Integer id){
        tripService.deleteTripById(id);
        return ResponseEntity.noContent().build();
    }
}