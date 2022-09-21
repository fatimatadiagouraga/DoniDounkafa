package com.example.doni.prestataire.service;

import com.example.doni.categorie.Categorie;
import com.example.doni.prestataire.Prestataire;

import java.util.List;

public interface PrestataireService {
    List<Prestataire> AllPrestataire();
    Prestataire AddPrestataire(Prestataire prestataire);
    Prestataire UpdatePrestataire(Prestataire prestataire,Long id);
    Prestataire PrestataireById (Long id);
    void DeletePrestataire(Long id);
}
