package pl.pjwstk.alicja.TripEvaluator.service;

import org.junit.jupiter.api.Test;
import pl.pjwstk.alicja.TripEvaluator.models.AuthorUser;
import pl.pjwstk.alicja.TripEvaluator.models.MainTypeOfConveyance;
import pl.pjwstk.alicja.TripEvaluator.models.Review;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TripServiceTest {
    //run robimy danego testu
    //zeby ruszyc trzeba napisac metode
    //TripService tripService = new TripService(new TripRepository); //nie moze byc bo tripRepository jest interface'm
    TripService tripService = new TripService(null); //tak mozemy :) ale nie beda dzialaly metody z repository (to na nastepnych zajceiach

    //utworzyc obiekt serwisu
    //1
    @Test
    void shouldAddSufixToTrip(){
        //GIVEN tu piszemy preRequizyty, dane wejsciowe, dane potrzebne do wykonania testu
        Trip trip = new Trip(null, "TITLE", "test dest", 100, 10, MainTypeOfConveyance.BIKE, List.of());
        //WHEN deklarujemy wywołanie, na koncu dajemy przyrownanie
        tripService.addSuffixToTrip(trip);
        //THEN musimy cos przyrownac, jakies asserty
        //Assertions.assertThat tak lub
        //musimy dodac nawiasy i import wybrac ta z assetionThat i wkladamy to co potrzebujemy
        assertThat(trip.getTitle())
                .isEqualTo("TITLE_SUFFIX");
    }
    @Test
    void shouldAddlankTripToTrip_null(){
        //GIVEN tu piszemy preRequizyty, dane wejsciowe, dane potrzebne do wykonania testu
        Trip trip = new Trip(null, null, "test dest", 100, 10, MainTypeOfConveyance.BIKE, List.of());
        //WHEN deklarujemy wywołanie, na koncu dajemy przyrownanie
        tripService.addSuffixToTrip(trip);
        //THEN musimy cos przyrownac, jakies asserty
        //Assertions.assertThat tak lub
        //musimy dodac nawiasy i import wybrac ta z assetionThat i wkladamy to co potrzebujemy
        assertThat(trip.getTitle())
                .isEqualTo("EMPTY");
    }
    @Test
    void shouldAddlankTripToTrip(){
        //GIVEN tu piszemy preRequizyty, dane wejsciowe, dane potrzebne do wykonania testu
        Trip trip = new Trip(null, "", "test dest", 100, 10, MainTypeOfConveyance.BIKE, List.of());
        //WHEN deklarujemy wywołanie, na koncu dajemy przyrownanie
        tripService.addSuffixToTrip(trip);
        //THEN musimy cos przyrownac, jakies asserty
        //Assertions.assertThat tak lub
        //musimy dodac nawiasy i import wybrac ta z assetionThat i wkladamy to co potrzebujemy
        assertThat(trip.getTitle())
                .isEqualTo("WOW");
    }
    //otestowac nasze metody
    //4
    @Test
    void isTripLongIfHasMoreThan14Days(){
        //GIVEN
        Trip trip = new Trip(null,"TITLE", "test dest", 100, 10, MainTypeOfConveyance.BIKE, List.of());
        //WHEN
        String tripLong = tripService.isTripLong(trip);
        //THEN
        assertThat(tripLong).isEqualTo("This Trip is Long");
    }
    @Test
    void isTripShortIfHasLessThan14Days(){
        //GIVEN
        Trip trip = new Trip(null,"TITLE", "test dest", 10, 10, MainTypeOfConveyance.BIKE, List.of());
        //WHEN
        String tripShort = tripService.isTripLong(trip);
        //THEN
        assertThat(tripShort).isEqualTo("Your trip is normal Duration");
    }
    @Test
    void isTripLongIfHas14Days(){
        //GIVEN
        Trip trip = new Trip(null,"TITLE", "test dest", 14, 10, MainTypeOfConveyance.BIKE, List.of());
        //WHEN
        String tripLong = tripService.isTripLong(trip);
        //THEN
        assertThat(tripLong).isEqualTo("This Trip is Long");
    }
    //todo: dokonczyc wszystkie testy
    //todo: poczyac o Mockito

    //5
    @Test
    void costTripMoreThan1000(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "test dest", 14, 1001, MainTypeOfConveyance.BIKE, List.of());
        //WHEN
        String expensiveTrip = tripService.isTripExpensive(trip);
        //THEN
        assertThat(expensiveTrip).isEqualTo("This Trip " + trip.getTitle() + "is expensive");
    }
    @Test
    void costTripLessThan1000(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "test dest", 14, 999, MainTypeOfConveyance.BIKE, List.of());
        //WHEN
        String expensiveTrip = tripService.isTripExpensive(trip);
        //THEN
        assertThat(expensiveTrip).isEqualTo("This Trip " + trip.getTitle() + "is not expensive");
    }
    @Test
    void costTripEquals1000(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "test dest", 14, 1000, MainTypeOfConveyance.BIKE, List.of());
        //WHEN
        String expensiveTrip = tripService.isTripExpensive(trip);
        //THEN
        assertThat(expensiveTrip).isEqualTo("This Trip " + trip.getTitle() + "is not expensive");
    }
    //6
    @Test
    void tripWithAirplane(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "test dest", 14, 999, MainTypeOfConveyance.AIRPLANE, List.of());
        //WHEN
        boolean isTripWithAirplane = tripService.isTripWithAirplane(trip);
        //THEN
        assertThat(isTripWithAirplane).isEqualTo(true);
    }
    @Test
    void tripWithoutAirplane(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "test dest", 14, 999, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        boolean isTripWithAirplane = tripService.isTripWithAirplane(trip);
        //THEN
        assertThat(isTripWithAirplane).isEqualTo(false);
    }
    //tu (do testow powyzej) bym zrobila kolejne testy dla wszystkich innych niz autobus, moze nawet w petli
    //7
    @Test
    void tripToSpain(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "Spain", 14, 999, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        boolean isTripToSpain = tripService.isDestinationSpain(trip);
        //THEN
        assertThat(isTripToSpain).isEqualTo(true);
    }
    @Test
    void tripNotToSpain(){
        //GIVEN
        Trip trip = new Trip(null, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 999, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        boolean isTripToSpain = tripService.isDestinationSpain(trip);
        //THEN
        assertThat(isTripToSpain).isEqualTo(false);
    }
    //8
//    public double costOfTwoTrips(Trip trip1, Trip trip2){
//        double costs;
//        costs = trip1.getCommission() + trip2.getCommission();
//        return costs;
//    }
    @Test
    void shouldAddCostOfTwoTrips(){
        //GIVEN
        Trip trip1 = new Trip(null, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of());
        Trip trip2 = new Trip(null, "TITLE", "Cracov", 14, 999, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        double costOfTwoTrips = tripService.costOfTwoTrips(trip1, trip2);
        //THEN
        assertThat(costOfTwoTrips).isEqualTo(1999);
    }
    //jaki negatywny do powyższego testu?
    //9
    @Test
    void hasTripTwoReviews(){
        //GIVEN
        List<Review> reviews = new ArrayList<>();
        AuthorUser author1 = new AuthorUser(null, "JEDREK",16, true);
        Review review1 = new Review(null, "mushrooms", author1, 1);
        Review review2 = new Review(null, "mushrooms", author1, 1);
        Trip trip = new Trip(1, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of(review1, review2));
        //WHEN
        String hasTripTwoReviews = tripService.hasTripTwoReviews(trip);
        //THEN
        assertThat(hasTripTwoReviews).isEqualTo("Trip has 2 reviews.");
    }
    @Test
    void tripHasLessThanTwoReviews(){
        //GIVEN
        List<Review> reviews = new ArrayList<>();
        AuthorUser author1 = new AuthorUser(null, "JEDREK",16, true);
        Review review = new Review(null, "mushrooms", author1, 1);
        Trip trip = new Trip(1, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of(review));
        //WHEN
        String hasTripTwoReviews = tripService.hasTripTwoReviews(trip);
        //THEN
        assertThat(hasTripTwoReviews).isEqualTo("Trip has not 2 reviews.");
    }
    @Test
    void tripHasMoreThanTwoReviews(){
        //GIVEN
        List<Review> reviews = new ArrayList<>();
        AuthorUser author1 = new AuthorUser(null, "JEDREK",16, true);
        Review review1 = new Review(null, "mushrooms", author1, 1);
        Review review2 = new Review(null, "mushrooms", author1, 1);
        Review review3 = new Review(null, "mushrooms", author1, 1);
        Trip trip = new Trip(1, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of(review1, review2, review3));
        //WHEN
        String hasTripTwoReviews = tripService.hasTripTwoReviews(trip);
        //THEN
        assertThat(hasTripTwoReviews).isEqualTo("Trip has not 2 reviews.");
    }
    //10
    @Test
    void isTripIdHigherThan50(){
        //GIVEN
        Trip trip = new Trip(55, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        boolean isTripIdHigherThan50 = tripService.isTripIdHigherThan50(trip);
        //THEN
        assertThat(isTripIdHigherThan50).isEqualTo(true);
    }
    @Test
    void isTripIdLessThan50(){
        //GIVEN
        Trip trip = new Trip(49, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        boolean isTripIdLessThan50 = tripService.isTripIdHigherThan50(trip);
        //THEN
        assertThat(isTripIdLessThan50).isEqualTo(false);
    }
    @Test
    void isTripIdEqual50(){
        //GIVEN
        Trip trip = new Trip(50, "TITLE", "Sri lanka, Sri Dzajawardanapura Cotte", 14, 1000, MainTypeOfConveyance.BUS, List.of());
        //WHEN
        boolean isTripIdEqual50 = tripService.isTripIdHigherThan50(trip);
        //THEN
        assertThat(isTripIdEqual50).isEqualTo(false);
    }
}
