package com.example.doni.panier.controller;

import com.example.doni.panier.Panier;
import com.example.doni.panier.service.PanierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PanierController {
    @Autowired
    PanierService panierService;

    @GetMapping("AllPanier")
    public List<Panier> AllPanier(){
        return panierService.AllPanier();
    }
    @PostMapping("AddPanier/{id}")
    public Panier AddPanier(@RequestBody Panier panier,@PathVariable("id") Long id){
        return panierService.AddPanier(panier,id);
    }
    @GetMapping("PanierById/{id}")
    public Panier PanierById(@PathVariable("id") Long id){
        return panierService.PanierById(id);
    }

    @GetMapping("PanierByPaysans/{id}")
    public List<Panier> PanierByPaysans(@PathVariable("id") Long id){
        return panierService.findPanierByPaysans(id);
    }
    @PutMapping("UpdatePanier/{id}")
    public Panier UpdatePanier(@RequestBody Panier panier,@PathVariable("id") Long id){
        return panierService.UpdatePanier(panier,id);
    }
    @PutMapping("UpdatePanierEtat/{id}")
    public Panier UpdatePanierEtat(@RequestBody Panier panier,@PathVariable("id") Long id){
        return panierService.updatePanierByid(panier,id);
    }
    @DeleteMapping("DeletePanier/{id}")
    public void DeletePanier(@PathVariable("id") Long id){
        panierService.DeletePanier(id);
    }

}
