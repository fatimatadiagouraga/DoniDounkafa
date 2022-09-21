package com.example.doni.categorie.service;

import com.example.doni.categorie.Categorie;
import com.example.doni.categorie.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService{
    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public List<Categorie> AllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie AddCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie UpdateCategorie(Categorie categorie, Long id) {
        Categorie existant = categorieRepository.findById(id).get();
        existant.setType(categorie.getType());
        return categorieRepository.save(existant);
    }

    @Override
    public Categorie CategorieById(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public void DeleteCategorie(Long id) {
      categorieRepository.deleteById(id);
    }
}
