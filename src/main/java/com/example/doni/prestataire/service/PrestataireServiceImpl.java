package com.example.doni.prestataire.service;

import com.example.doni.prestataire.Prestataire;
import com.example.doni.prestataire.repository.PrestataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrestataireServiceImpl implements PrestataireService{
    @Autowired
    PrestataireRepository prestataireRepository;
    @Override
    public List<Prestataire> AllPrestataire() {
        return prestataireRepository.findAll();
    }

    @Override
    public Prestataire AddPrestataire(Prestataire prestataire) {
        return prestataireRepository.save(prestataire);
    }

    @Override
    public Prestataire UpdatePrestataire(Prestataire prestataire, Long id) {
        Prestataire existant = prestataireRepository.findById(id).get();
        existant.setPrenom(prestataire.getPrenom());
        existant.setNom(prestataire.getNom());
        existant.setTelephone(prestataire.getTelephone());
        existant.setAdresse(prestataire.getAdresse());
        return prestataireRepository.save(existant);
    }

    @Override
    public Prestataire PrestataireById(Long id) {
        return prestataireRepository.findById(id).get();
    }

    @Override
    public void DeletePrestataire(Long id) {
      prestataireRepository.deleteById(id);
    }
}
