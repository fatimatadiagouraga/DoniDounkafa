package com.example.doni.campagne.service;

import com.example.doni.campagne.Campagne;
import com.example.doni.categorie.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CampagneService {
    List<Campagne> AllCampagne();
    Campagne AddCampagne(Campagne campagne);
    Campagne UpdateCampagne(Campagne campagne,Long id);
    Campagne CampagneById (Long id);
    void DeleteCampagne(Long id);
}
