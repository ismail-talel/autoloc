package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.Entities.CategorieVehicule;
import tn.esprit.autoloc.Entities.StatutVehicule;
import tn.esprit.autoloc.Entities.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByMarque(String marque);

    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    List<Vehicule> findByStatut(StatutVehicule statut);

    List<Vehicule> findByMarqueContaining(String marque);

    List<Vehicule> findByModeleStartingWith(String debut);

    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);

    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);

    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);

    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);

    List<Vehicule> findByCategorieOrCategorie(CategorieVehicule c1, CategorieVehicule c2);

    List<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif);

    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);

    List<Vehicule> findAllByOrderByTarifJournalierDesc();
}


