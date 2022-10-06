package com.example.doni.commande.service;

import com.example.doni.activite.Activite;
import com.example.doni.commande.Commande;
import com.example.doni.panier.Panier;
import com.example.doni.produitAchete.ProduitAchete;

import java.util.List;



public interface CommandeService {
    List<Commande> AllCommande();
    Commande AddCommande(Commande commande);
    Commande UpdateCommande(Commande commande,Long id);
    Commande CommandeById (Long id);
    void DeleteCommande(Long id);
    String AddCommandeList(List<Commande> commandes);
    List<Commande> findCommandeByPaysans(Long id);
    List<Commande> findCommandeByEtat();
}
