package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Maintenance;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IMaintenance {



    Maintenance addMaintenance(Maintenance m);

    Set<Maintenance> retrieveMaintenance();

    List<Maintenance> retrieveMaintenances();

    Maintenance updateMaintenance(Maintenance m);

    void deleteMaintenance(Long id);

    List<Maintenance> getByDateFinBetween(LocalDate dateDebut, LocalDate dateFin);
}