package com.example.doni.produitAchete.service;

import com.example.doni.produit.repository.ProduitRepository;
import com.example.doni.produitAchete.ProduitAchete;
import com.example.doni.produitAchete.repository.ProduitAchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProduitAchServiceImpl implements ProduitAchService{
    @Autowired
    ProduitAchRepository produitAchRepository;


    @Override
    public List<ProduitAchete> AllProduitAchete() {
        return produitAchRepository.findAll();
    }

    @Override
    public ProduitAchete AddProduitAchete(ProduitAchete produitAchete) {
        return produitAchRepository.save(produitAchete);
    }

    @Override
    public ProduitAchete UpdateProduitAchete(ProduitAchete produitAchete, Long id) {
        ProduitAchete existant = produitAchRepository.findById(id).get();
        existant.setDate(produitAchete.getDate());

        return produitAchRepository.save(existant);
    }

    @Override
    public ProduitAchete ProduitAcheteById(Long id) {
        return produitAchRepository.findById(id).get();
    }

    @Override
    public void DeleteProduitAchete(Long id) {
      produitAchRepository.findById(id);
    }

    @Override
    public String AddProduitAcheterList(List<ProduitAchete> produitAchetes) {
        List<ProduitAchete> listProduitAche = new ArrayList<>();
        produitAchRepository.saveAll(produitAchetes).forEach(listProduitAche::add);
        return "Achat effectuer avec succès";
    }
}
