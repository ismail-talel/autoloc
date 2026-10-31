package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Services.IAgence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name = "Gestion Agence")
@RequestMapping("/api/agence")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgence iAgence;


    @Operation(summary = "Ajouter une agence")
    @PostMapping("/addAgence")
    public Agence ajouterAgence(@RequestBody Agence a) {
        return iAgence.addAgence(a);
    }

    @Operation(summary = "Récupérer toutes les agences (Set)")
    @GetMapping("/getAll")
    public Set<Agence> retrieveAgence() {
        return new HashSet<>(iAgence.retrieveAgence());
    }

    @Operation(summary = "Récupérer toutes les agences (List)")
    @GetMapping("/getAllAgences")
    public List<Agence> recupererAgence() {
        return iAgence.retrieveAgences();
    }

    @Operation(summary = "Mettre à jour une agence")
    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence a) {
        return iAgence.updateAgence(a);
    }

    @Operation(summary = "Supprimer une agence par ID")
    @DeleteMapping("/deleteAgenceById/{id}")
    public void deleteAgence(@PathVariable Long id) {
        iAgence.deleteAgence(id);
    }

    @Operation(summary = "4 - Rechercher les agences situées dans une ville donnée")
    @GetMapping("/ville/{ville}")
    public List<Agence> getAgencesByVille(@PathVariable String ville) {
        return iAgence.getByVille(ville);
    }

    @Operation(summary = "7 - Rechercher les agences dont le nom se termine par une chaîne")
    @GetMapping("/nom-finit-par/{chaine}")
    public List<Agence> getAgencesByNomEndingWith(@PathVariable String chaine) {
        return iAgence.getByNomEndingWith(chaine);
    }
}
