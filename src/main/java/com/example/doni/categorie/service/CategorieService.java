package com.example.doni.categorie.service;

import com.example.doni.categorie.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategorieService {
    List<Categorie> AllCategorie();
    Categorie AddCategorie(Categorie categorie);
    Categorie UpdateCategorie(Categorie categorie,Long id);
    Categorie CategorieById (Long id);
    void DeleteCategorie(Long id);
}
