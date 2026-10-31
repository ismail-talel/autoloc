package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.CategorieVehicule;
import tn.esprit.autoloc.Entities.StatutVehicule;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Repositories.AgenceRepo;
import tn.esprit.autoloc.Repositories.VehiculeRepo;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {

    private final VehiculeRepo vehiculeRepo;
    private final AgenceRepo agenceRepo;



    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    public Vehicule afficherVehicule(Long id) {
        return vehiculeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : " + id));
    }

    @Override
    public Vehicule modifierVehicule(Long id, Vehicule v) {
        Vehicule existant = afficherVehicule(id);
        existant.setImmatriculation(v.getImmatriculation());
        existant.setMarque(v.getMarque());
        existant.setModele(v.getModele());
        existant.setCategorie(v.getCategorie());
        existant.setTarifJournalier(v.getTarifJournalier());
        existant.setStatut(v.getStatut());
        return vehiculeRepo.save(existant);
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepo.deleteById(id);
    }

    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = afficherVehicule(idVehicule);
        Agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
        return vehiculeRepo.save(vehicule);
    }



    @Override
    public List<Vehicule> getByMarque(String marque) {
        return vehiculeRepo.findByMarque(marque);
    }

    @Override
    public List<Vehicule> getByCategorie(CategorieVehicule categorie) {
        return vehiculeRepo.findByCategorie(categorie);
    }

    @Override
    public List<Vehicule> getDisponibles() {
        return vehiculeRepo.findByStatut(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> getByMarqueContaining(String marque) {
        return vehiculeRepo.findByMarqueContaining(marque);
    }

    @Override
    public List<Vehicule> getByModeleStartingWith(String debut) {
        return vehiculeRepo.findByModeleStartingWith(debut);
    }

    @Override
    public List<Vehicule> getByTarifSuperieurA(BigDecimal tarif) {
        return vehiculeRepo.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> getByTarifInferieurA(BigDecimal tarif) {
        return vehiculeRepo.findByTarifJournalierLessThan(tarif);
    }

    @Override
    public List<Vehicule> getByTarifSupOuEgal(BigDecimal tarif) {
        return vehiculeRepo.findByTarifJournalierGreaterThanEqual(tarif);
    }

    @Override
    public List<Vehicule> getByMarqueEtDisponible(String marque) {
        return vehiculeRepo.findByMarqueAndStatut(marque, StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> getSuvOuBerline() {
        return vehiculeRepo.findByCategorieOrCategorie(CategorieVehicule.SUV, CategorieVehicule.BERLINE);
    }

    @Override
    public List<Vehicule> getByMarqueEtTarifInferieur(String marque, BigDecimal tarif) {
        return vehiculeRepo.findByMarqueAndTarifJournalierLessThan(marque, tarif);
    }

    @Override
    public List<Vehicule> getDisponiblesTarifCroissant() {
        return vehiculeRepo.findByStatutOrderByTarifJournalierAsc(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> getTousTarifDecroissant() {
        return vehiculeRepo.findAllByOrderByTarifJournalierDesc();
    }
}