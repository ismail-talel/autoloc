package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Services.IReservation;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name = "Gestion Reservation")
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservation iReservation;

    @Operation(summary = "Ajouter une réservation")
    @PostMapping("/addReservation")
    public Reservation ajouterReservation(@RequestBody Reservation r) {
        return iReservation.addReservation(r);
    }

    @Operation(summary = "Récupérer toutes les réservations (Set)")
    @GetMapping("/getAll")
    public Set<Reservation> retrieveReservation() {
        return new HashSet<>(iReservation.retrieveReservation());
    }

    @Operation(summary = "Récupérer toutes les réservations (List)")
    @GetMapping("/getAllReservations")
    public List<Reservation> recupererReservation() {
        return iReservation.retrieveReservations();
    }

    @Operation(summary = "Mettre à jour une réservation")
    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return iReservation.updateReservation(r);
    }

    @Operation(summary = "Supprimer une réservation par ID")
    @DeleteMapping("/deleteReservationById/{id}")
    public void deleteReservation(@PathVariable Long id) {
        iReservation.deleteReservation(id);
    }

    // ==========================================
    // 2. MÉTHODES DE RECHERCHE (Atelier)
    // ==========================================

    @Operation(summary = "14 - Réservations dont la date de début est postérieure à une date")
    @GetMapping("/date-debut-apres")
    public List<Reservation> getReservationsDateDebutApres(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return iReservation.getByDateDebutAfter(date);
    }

    @Operation(summary = "15 - Réservations dont la date de fin est antérieure à une date")
    @GetMapping("/date-fin-avant")
    public List<Reservation> getReservationsDateFinAvant(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return iReservation.getByDateFinBefore(date);
    }
}