package com.example.doni.commande.service;

import com.example.doni.commande.Commande;
import com.example.doni.commande.EtatCommande;
import com.example.doni.commande.repository.CommandeRepository;
import com.example.doni.produitAchete.ProduitAchete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> AllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande AddCommande(Commande commande) {

        return commandeRepository.save(commande);
    }

    @Override
    public Commande UpdateCommande(Commande commande, Long id) {
        Commande existant = commandeRepository.findById(id).get();
        existant.setEtatCommande(commande.getEtatCommande());
        return commandeRepository.save(existant);
    }

    @Override
    public Commande CommandeById(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public void DeleteCommande(Long id) {
      commandeRepository.deleteById(id);
    }

    @Override
    public String AddCommandeList(List<Commande> commandes) {
        List<Commande> listCommande = new ArrayList<>();
        commandeRepository.saveAll(commandes).forEach(listCommande::add);
        return "Achat effectuer avec succès";
    }

    @Override
    public List<Commande> findCommandeByPaysans(Long id) {
        return commandeRepository.findCommandeByPaysans(id);
    }

    @Override
    public List<Commande> findCommandeByEtat() {
        return commandeRepository.findCommandeByEtatCommande();
    }
}
