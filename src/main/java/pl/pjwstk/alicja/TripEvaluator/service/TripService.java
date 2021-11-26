package pl.pjwstk.alicja.TripEvaluator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.alicja.TripEvaluator.models.AuthorUser;
import pl.pjwstk.alicja.TripEvaluator.models.MainTypeOfConveyance;
import pl.pjwstk.alicja.TripEvaluator.models.Review;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;
import pl.pjwstk.alicja.TripEvaluator.repository.ReviewRepository;
import pl.pjwstk.alicja.TripEvaluator.repository.TripRepository;

import java.util.List;

//todo: save - zapisuje nowa wycieczke, ktora ma list review, kazde review ma autora
//todo: addReview - dodaje rewiec (ktore ma autora) do istniejacej wycieczki
//todo: findAll - zwraca wszystkie wycieczki
//todo: findId - parametr ID ma byc przyjedty z adresu i przekazany dalej
//todo: delete - parametr ID ma byc przyjety z adresu i przekazany dalej


@Service //bez tej adnotacji TripService nie jest nigdy uzyte, teraz jest uzywana
public class TripService { //klasa wspomagajaca operacje na bazie danych

    //wstrzykniecie repozytorium do serwisu poprzez konstruktor serwisu
    private final TripRepository tripRepository;
    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    //ponizej beda metody jakie ma wykonywac...
    //przykladowa metoda
    //tu metoda na generowanie kolejnych id dla tych samych trip
    public Trip buildExampleOfTrip(){
        AuthorUser authorUser1 = new AuthorUser(null, "Alicja", 3, true);
        Review review1 = new Review(null, "too long trip", authorUser1, 3);
        List<Review> listOfComponents = List.of(review1);

        Trip trip = new Trip(null, "Malaga", "Malaga", 7, 5000, MainTypeOfConveyance.AIRPLANE, listOfComponents);
        return tripRepository.save(trip);
    }
    //save
    public void save(Trip trip){
        tripRepository.save(trip);
    }
    //findAll
    public List<Trip> listOfTrips(){
        return tripRepository.findAll();
    }
    //findTripId
    public Trip getTripById(Integer id){
        return tripRepository.getById(id);
    }
    //delete trip
    public void deleteTrip(Integer id){
        tripRepository.deleteById(id);
    }
}
