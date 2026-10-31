package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.CategorieVehicule;
import tn.esprit.autoloc.Entities.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehicule {
    Vehicule ajouterVehicule(Vehicule vehicule);
    List<Vehicule> afficherVehicules();
    Vehicule afficherVehicule(Long id);
    Vehicule modifierVehicule(Long id, Vehicule vehicule);
    void supprimerVehicule(Long id);
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    List<Vehicule> getByMarque(String marque);
    List<Vehicule> getByCategorie(CategorieVehicule categorie);
    List<Vehicule> getDisponibles();
    List<Vehicule> getByMarqueContaining(String marque);
    List<Vehicule> getByModeleStartingWith(String debut);
    List<Vehicule> getByTarifSuperieurA(BigDecimal tarif);
    List<Vehicule> getByTarifInferieurA(BigDecimal tarif);
    List<Vehicule> getByTarifSupOuEgal(BigDecimal tarif);
    List<Vehicule> getByMarqueEtDisponible(String marque);
    List<Vehicule> getSuvOuBerline();
    List<Vehicule> getByMarqueEtTarifInferieur(String marque, BigDecimal tarif);
    List<Vehicule> getDisponiblesTarifCroissant();
    List<Vehicule> getTousTarifDecroissant();
}


