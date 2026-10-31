package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.CategorieVehicule;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Services.IVehicule;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Tag(name = "Gestion Vehicule")
@RequestMapping("/api/Vehicule")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehicule iVehicule;



    @Operation(summary = "ajouter vehicule dans la BD")
    @PostMapping("/addVehicule")
    public ResponseEntity<Vehicule> ajouter(@Valid @RequestBody Vehicule vehicule) {
        Vehicule nouveau = iVehicule.ajouterVehicule(vehicule);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveau);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<Vehicule>> afficherTous() {
        return ResponseEntity.ok(iVehicule.afficherVehicules());
    }

    @GetMapping("/GetById/{id}")
    public ResponseEntity<Vehicule> afficherParId(
            @Parameter(description = "l'identifiant du vehicule")
            @PathVariable Long id) {
        return ResponseEntity.ok(iVehicule.afficherVehicule(id));
    }

    @PutMapping("/PutById/{id}")
    public ResponseEntity<Vehicule> modifier(
            @PathVariable Long id,
            @Valid @RequestBody Vehicule vehicule) {
        return ResponseEntity.ok(iVehicule.modifierVehicule(id, vehicule));
    }

    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iVehicule.supprimerVehicule(id);
    }

    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule,
                                     @PathVariable Long idAgence) {
        return iVehicule.affecterVehicule(idVehicule, idAgence);
    }



    @Operation(summary = "1 - Véhicules d'une marque")
    @GetMapping("/marque/{marque}")
    public List<Vehicule> byMarque(@PathVariable String marque) {
        return iVehicule.getByMarque(marque);
    }

    @Operation(summary = "2 - Véhicules d'une catégorie")
    @GetMapping("/categorie/{categorie}")
    public List<Vehicule> byCategorie(@PathVariable CategorieVehicule categorie) {
        return iVehicule.getByCategorie(categorie);
    }

    @Operation(summary = "3 - Véhicules DISPONIBLES")
    @GetMapping("/disponibles")
    public List<Vehicule> disponibles() {
        return iVehicule.getDisponibles();
    }




    @Operation(summary = "5 - Marque contient une chaîne")
    @GetMapping("/marque-contient/{s}")
    public List<Vehicule> marqueContient(@PathVariable String s) {
        return iVehicule.getByMarqueContaining(s);
    }

    @Operation(summary = "6 - Modèle commence par une chaîne")
    @GetMapping("/modele-commence/{s}")
    public List<Vehicule> modeleCommence(@PathVariable String s) {
        return iVehicule.getByModeleStartingWith(s);
    }



    @Operation(summary = "8 - Tarif > 100 DT")
    @GetMapping("/tarif-sup-100")
    public List<Vehicule> tarifSup100() {
        return iVehicule.getByTarifSuperieurA(BigDecimal.valueOf(100));
    }

    @Operation(summary = "9 - Tarif < 50 DT")
    @GetMapping("/tarif-inf-50")
    public List<Vehicule> tarifInf50() {
        return iVehicule.getByTarifInferieurA(BigDecimal.valueOf(50));
    }

    @Operation(summary = "10 - Tarif >= 80 DT")
    @GetMapping("/tarif-sup-egal-80")
    public List<Vehicule> tarifSupEgal80() {
        return iVehicule.getByTarifSupOuEgal(BigDecimal.valueOf(80));
    }



    @Operation(summary = "11 - Marque donnée ET DISPONIBLE")
    @GetMapping("/marque/{marque}/disponibles")
    public List<Vehicule> marqueDisponible(@PathVariable String marque) {
        return iVehicule.getByMarqueEtDisponible(marque);
    }

    @Operation(summary = "12 - Catégorie SUV OU BERLINE")
    @GetMapping("/suv-ou-berline")
    public List<Vehicule> suvOuBerline() {
        return iVehicule.getSuvOuBerline();
    }

    @Operation(summary = "13 - Marque donnée ET tarif < 100 DT")
    @GetMapping("/marque/{marque}/tarif-inf-100")
    public List<Vehicule> marqueTarifInf100(@PathVariable String marque) {
        return iVehicule.getByMarqueEtTarifInferieur(marque, BigDecimal.valueOf(100));
    }



    @Operation(summary = "17 - Disponibles par tarif croissant")
    @GetMapping("/disponibles/tarif-croissant")
    public List<Vehicule> disponiblesTarifCroissant() {
        return iVehicule.getDisponiblesTarifCroissant();
    }

    @Operation(summary = "18 - Tous les véhicules par tarif décroissant")
    @GetMapping("/tarif-decroissant")
    public List<Vehicule> tarifDecroissant() {
        return iVehicule.getTousTarifDecroissant();
    }
}