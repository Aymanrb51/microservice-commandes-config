package com.cas.services;

import com.cas.entities.commande;
import com.cas.repositories.commandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commandeService {
    private final commandeRepository repository;

    public commandeService(commandeRepository repository) {
        this.repository = repository;
    }

    public List<commande> getAllCommandes() {
        return repository.findAll();
    }

    public List<commande> getRecentCommandes(int days) {
        return repository.findRecent(days);
    }

    public commande createCommande(commande commande) {
        return repository.save(commande);
    }

    public void deleteCommande(Long id) {
        repository.deleteById(id);
    }
}