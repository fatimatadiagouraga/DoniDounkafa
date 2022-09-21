package com.example.doni.activite.service;


import com.example.doni.activite.Activite;


import java.util.List;

public interface ActiviteService {
    List<Activite> AllActivite();
    Activite AddActivite(Activite activite);
    Activite UpdateActivite(Activite activite,Long id);
    Activite ActiviteById (Long id);
    void DeleteActivite(Long id);
}
