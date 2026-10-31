package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Maintenance; // Import de l'entité
import tn.esprit.autoloc.Services.IMaintenance;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name = "Gestion Maintenance")
@RequestMapping("/api/maintenance")
@RequiredArgsConstructor
public class MantenanceController {
    private final IMaintenance iMaintenance;



    @Operation(summary = "16 - Maintenances dont la date de fin est comprise entre deux dates")
    @GetMapping("/date-fin-entre")
    public List<Maintenance> getMaintenancesBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin) {
        return iMaintenance.getByDateFinBetween(dateDebut, dateFin);
    }
}