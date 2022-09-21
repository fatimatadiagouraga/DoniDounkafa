package com.example.doni.activite.service;

import com.example.doni.activite.Activite;
import com.example.doni.activite.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActiviteServiceImpl implements ActiviteService{
    @Autowired
    ActiviteRepository activiteRepository;

    @Override
    public List<Activite> AllActivite() {
        return activiteRepository.findAll();
    }

    @Override
    public Activite AddActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    @Override
    public Activite UpdateActivite(Activite activite, Long id) {
        Activite existant = activiteRepository.findById(id).get();
        existant.setTypeActivite(activite.getTypeActivite());
        existant.setDescription(activite.getDescription());
        return activiteRepository.save(activite);
    }

    @Override
    public Activite ActiviteById(Long id) {
        return activiteRepository.findById(id).get();
    }

    @Override
    public void DeleteActivite(Long id) {
    activiteRepository.deleteById(id);
    }
}
