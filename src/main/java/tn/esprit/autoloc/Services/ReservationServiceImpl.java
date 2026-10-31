package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Repositories.ReservationRepo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepo reservationRepo;

    // ==========================================
    // CRUD de base
    // ==========================================

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Set<Reservation> retrieveReservation() {
        return new HashSet<>(reservationRepo.findAll());
    }

    @Override
    public List<Reservation> retrieveReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }

    // ==========================================
    // Recherches (Atelier)
    // ==========================================

    @Override
    public List<Reservation> getByDateDebutAfter(LocalDate date) {
        return reservationRepo.findByDateDebutAfter(date);
    }

    @Override
    public List<Reservation> getByDateFinBefore(LocalDate date) {
        return reservationRepo.findByDateFinBefore(date);
    }
}