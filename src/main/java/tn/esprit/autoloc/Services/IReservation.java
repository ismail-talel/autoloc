package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IReservation {


    Reservation addReservation(Reservation r);
    Set<Reservation> retrieveReservation();
    List<Reservation> retrieveReservations();
    Reservation updateReservation(Reservation r);
    void deleteReservation(Long id);
    List<Reservation> getByDateDebutAfter(LocalDate date);
    List<Reservation> getByDateFinBefore(LocalDate date);
}