package com.example.doni.panier.service;

import com.example.doni.panier.Panier;
import com.example.doni.panier.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PanierServiceImpl implements PanierService{

    @Autowired
    PanierRepository panierRepository;

    @Override
    public List<Panier> AllPanier() {
        return panierRepository.findAll();
    }

    @Override
    public Panier AddPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public Panier UpdatePanier(Panier panier, Long id) {
        Panier existant = panierRepository.findById(id).get();
        existant.setPaysans(panier.getPaysans());
        existant.setProduit(panier.getProduit());
        return panierRepository.save(existant);
    }

    @Override
    public Panier PanierById(Long id) {
        return panierRepository.findById(id).get();
    }

    @Override
    public void DeletePanier(Long id) {
        panierRepository.deleteById(id);
    }
}
