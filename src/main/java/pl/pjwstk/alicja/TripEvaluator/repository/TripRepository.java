package pl.pjwstk.alicja.TripEvaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjwstk.alicja.TripEvaluator.models.Trip;
import org.springframework.stereotype.Repository;

//bo chcemy miec mozliwosc operacji na bazie danych, Spring wie że z danej klasy musi utworzyc beana  i nadac mu Id taki sam jak nazwa klasy, tylko mala litera, dzieki temu taki bean moze
// byx wstrzykiwany za pomoca adnotacji do innych beanow, wstrzykiwanie zaleznosci przez konstruktor
@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> { //operujemy na encji trip i typ klucza głownego //w repozytorium jest zestaw umozliwiajacy manipulacje na encji trip


}
