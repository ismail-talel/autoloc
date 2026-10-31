package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Repositories.MaintenanceRepo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenance {

    // 1. Injection du Repository (ne jamais appeler la classe en statique)
    private final MaintenanceRepo maintenanceRepo;

    // ==========================================
    // 2. Méthodes CRUD (pour respecter l'interface)
    // ==========================================

    @Override
    public Maintenance addMaintenance(Maintenance m) {
        return maintenanceRepo.save(m);
    }

    @Override
    public Set<Maintenance> retrieveMaintenance() {
        return new HashSet<>(maintenanceRepo.findAll());
    }

    @Override
    public List<Maintenance> retrieveMaintenances() {
        return maintenanceRepo.findAll();
    }

    @Override
    public Maintenance updateMaintenance(Maintenance m) {
        return maintenanceRepo.save(m);
    }

    @Override
    public void deleteMaintenance(Long id) {
        maintenanceRepo.deleteById(id);
    }

    // ==========================================
    // 3. Méthode de recherche (Atelier - Scénario 16)
    // ==========================================

    @Override
    public List<Maintenance> getByDateFinBetween(LocalDate debut, LocalDate fin) {
        // On appelle l'instance "maintenanceRepo" (et non la classe)
        // On utilise "findByDateFinBetween" (le nom exact défini dans le Repo)
        return maintenanceRepo.findByDateFinBetween(debut, fin);
    }
}