package com.cas.repositories;

import com.cas.entities.commande;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class commandeRepository {
    private final List<commande> commandes = new ArrayList<>();

    public List<commande> findAll() {
        return commandes;
    }

    public List<commande> findRecent(int days) {
        LocalDate cutoffDate = LocalDate.now().minusDays(days);
        return commandes.stream()
                .filter(commande -> commande.getDate().isAfter(cutoffDate))
                .collect(Collectors.toList());
    }

    public commande save(commande commande) {
        commandes.add(commande);
        return commande;
    }

    public void deleteById(Long id) {
        commandes.removeIf(commande -> commande.getId().equals(id));
    }
}