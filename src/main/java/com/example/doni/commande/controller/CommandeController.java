package com.example.doni.commande.controller;


import com.example.doni.commande.Commande;
import com.example.doni.commande.service.CommandeService;

import com.example.doni.panier.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @GetMapping("AllCommande")
    public List<Commande> AllActivite(){
        return commandeService.AllCommande();
    }
    @GetMapping("CommandeById/{id}")
    public Commande ActiviteById(@PathVariable("id") Long id){
        return  commandeService.CommandeById(id);
    }
    @PutMapping("UpdateCommande/{id}")
    public Commande UpdateActivite(@RequestBody Commande commande, @PathVariable("id") Long id){
        return commandeService.UpdateCommande(commande,id);
    }
    @PostMapping("AddCommande")
    public Commande AddActivite(@RequestBody Commande commande){
        return commandeService.AddCommande(commande);
    }
    @DeleteMapping("DeleteCommande/{id}")
    public void DeleteActivite(Long id){
        commandeService.DeleteCommande(id);
    }

    @PostMapping("AddAllCommande")
    public String AddAllCommande(@RequestBody List<Commande> listCommande){
        return commandeService.AddCommandeList(listCommande);
    }
    @GetMapping("CommandeByPaysans/{id}")
    public List<Commande> CommandeByPaysans(@PathVariable("id") Long id){
        return commandeService.findCommandeByPaysans(id);
    }
    @GetMapping("AllCommandeEtat")
    public List<Commande> AllCommandeEtat(){
        return commandeService.findCommandeByEtat();
    }
}
