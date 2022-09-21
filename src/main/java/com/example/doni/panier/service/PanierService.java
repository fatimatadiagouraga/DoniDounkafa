package com.example.doni.panier.service;

import com.example.doni.panier.Panier;
import com.example.doni.utilisateur.paysans.Paysans;

import java.util.List;

public interface PanierService {
    List<Panier> AllPanier();
    Panier AddPanier(Panier panier);
    Panier UpdatePanier(Panier panier, Long id);
    Panier PanierById(Long id);
    void DeletePanier(Long id);
}
